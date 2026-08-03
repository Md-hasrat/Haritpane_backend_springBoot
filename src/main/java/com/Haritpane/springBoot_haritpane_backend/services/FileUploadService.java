package com.Haritpane.springBoot_haritpane_backend.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String uploadFile(MultipartFile file);
    void deleteFile(String fileKey);
}
