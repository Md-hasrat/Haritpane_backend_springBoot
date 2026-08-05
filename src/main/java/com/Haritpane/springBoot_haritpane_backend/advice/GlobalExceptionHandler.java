package com.Haritpane.springBoot_haritpane_backend.advice;

import com.Haritpane.springBoot_haritpane_backend.exception.BadRequestException;
import com.Haritpane.springBoot_haritpane_backend.exception.EmailSendingException;
import com.Haritpane.springBoot_haritpane_backend.exception.FileUploadException;
import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(
            ResourceNotFoundException ex) {

        return ResponseHandler.generateResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                null
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(
            BadRequestException ex) {

        return ResponseHandler.generateResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                null
        );
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ApiResponse<Object>> handleFileUploadException(
            FileUploadException ex){

        return ResponseHandler.generateResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                null
        );
    }

    @ExceptionHandler(EmailSendingException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmailSendingException(
            EmailSendingException ex
    ){
        return ResponseHandler.generateResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                null
        );
    }

}
