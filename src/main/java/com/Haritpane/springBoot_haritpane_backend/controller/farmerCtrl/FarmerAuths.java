package com.Haritpane.springBoot_haritpane_backend.controller.farmerCtrl;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.LoginDto;
import com.Haritpane.springBoot_haritpane_backend.services.farmerService.FarmerAuthService;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.OtpUtil;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/farmer/auth")
public class FarmerAuths {

    private final FarmerAuthService farmerAuthService;

    @PostMapping("/sendOtp")
    public ResponseEntity<ApiResponse<String>> sendOtp(
            @RequestBody String phone
    ){
        String otp = OtpUtil.generateOtp();

        return ResponseHandler.generateResponse(
                "OTP generated successfully",
                HttpStatus.OK,
                otp
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginDto>> login(
            @RequestBody String phone
    ){
            LoginDto response = farmerAuthService.login(phone);

            return ResponseHandler.generateResponse(
                    "Login Successfully",
                    HttpStatus.OK,
                    response
            );

    }
}
