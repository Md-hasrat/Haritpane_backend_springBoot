package com.Haritpane.springBoot_haritpane_backend.controller;

import com.Haritpane.springBoot_haritpane_backend.services.SendEmailService;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final SendEmailService sendEmailService;

    @GetMapping("/mail")
    public ResponseEntity<ApiResponse<Object>> sendMail() {

        String html = """
                <h2>Hello Hasrat</h2>
                <h1>This is a test email.</h1>
                """;

        sendEmailService.sendHtmlEmail(
                "md.hasrat@mobulous.com",
                "Test Email",
                html
        );
        return ResponseHandler.generateResponse("Otp send to your email", HttpStatus.OK,"");
    }
}