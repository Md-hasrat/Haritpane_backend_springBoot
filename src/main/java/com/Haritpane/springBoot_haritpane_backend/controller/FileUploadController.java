package com.Haritpane.springBoot_haritpane_backend.controller;

import com.Haritpane.springBoot_haritpane_backend.services.FileUploadService;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<String>> uploadFile(
            @RequestParam("file") MultipartFile file){

        String url = fileUploadService.uploadFile(file);

        return ResponseHandler.generateResponse(
                "File uploaded successfully",
                HttpStatus.OK,
                url
        );
    }
}
