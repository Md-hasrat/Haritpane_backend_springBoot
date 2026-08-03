package com.Haritpane.springBoot_haritpane_backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static <T> ResponseEntity<ApiResponse<T>> generateResponse(
            String message,
            HttpStatus status,
            T data) {

        ApiResponse<T> response = new ApiResponse<>(
                status.is2xxSuccessful(),
                message,
                status.value(),
                data
        );

        return new ResponseEntity<>(response, status);
    }
}
