package com.Haritpane.springBoot_haritpane_backend.controller.farmerCtrl;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.requestDto.FarmerUpdateProfileDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.FarmerProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.LoginDto;
import com.Haritpane.springBoot_haritpane_backend.repository.FarmerRepository;
import com.Haritpane.springBoot_haritpane_backend.services.farmerService.FarmerAuthService;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.OtpUtil;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/farmer/auth")
public class FarmerAuths {

    private final FarmerAuthService farmerAuthService;
    private final FarmerRepository farmerRepository;

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
            @RequestBody Map<String, String> request
    ){
            String phone = request.get("phone");
            LoginDto response = farmerAuthService.login(phone);

            return ResponseHandler.generateResponse(
                    "Login Successfully",
                    HttpStatus.OK,
                    response
            );
    }

    @GetMapping("/getProfile")
    public ResponseEntity<ApiResponse<FarmerProfileResponseDto>> getProfile(
            Authentication authentication
    ){
        Long farmerId = Long.parseLong(authentication.getName());
        FarmerProfileResponseDto response = farmerAuthService.getProfile(farmerId);

        return ResponseHandler.generateResponse(
                "Profile fetched successfully",
                HttpStatus.OK,
                response
        );
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<ApiResponse<FarmerProfileResponseDto>> updateFarmerProfile(
            @RequestBody FarmerUpdateProfileDto farmerUpdateProfileDto,
            Authentication authentication
    ){

        Long farmerId = Long.parseLong(authentication.getName());

        FarmerProfileResponseDto response = farmerAuthService.updateProfile(farmerId, farmerUpdateProfileDto);

        return ResponseHandler.generateResponse(
                "Farmer profile updated successfully",
                HttpStatus.OK,
                response
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logoutFarmer(
            Authentication authentication
    ){

        Long farmerId = Long.parseLong(authentication.getName());

        farmerAuthService.logout(farmerId);
         return ResponseHandler.generateResponse(
                 "Farmer logout successfully",
                 HttpStatus.OK,
                 null
         );
    }

}
