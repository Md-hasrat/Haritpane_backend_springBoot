package com.Haritpane.springBoot_haritpane_backend.controller.serviceProviderctrl;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderLoginRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderUpdateProfileRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.ProviderAuthService;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/provider/auth")
public class ServiceProviderAuths {

    @Autowired
    private  ProviderAuthService providerAuthService;

    @RestController
    @RequestMapping("/provider/auth")
    public class ServiceProviderAuthController {

        @Autowired
        private ProviderAuthService providerAuthService;

        @PostMapping("/login")
        public ResponseEntity<ApiResponse<ServiceProviderLoginResponseDto>> loginProviders(
                @RequestBody @Validated ServiceProviderLoginRequestDto request) {

            ServiceProviderLoginResponseDto response =
                    providerAuthService.loginServiceProvider(request);

            return ResponseHandler.generateResponse(
                    "Login successful",
                    HttpStatus.OK,
                    response
            );
        }
    }

    @PutMapping("/updateProfile")
    public  ResponseEntity<ApiResponse<ServiceProviderProfileResponseDto>>  updateProfile(
            Authentication authentication,
            @RequestBody @Validated ServiceProviderUpdateProfileRequestDto request
    ){
        Long providerId = Long.parseLong(authentication.getName());

        System.out.println("Controller reached");
        System.out.println(authentication);
        System.out.println(authentication.getName());

        ServiceProviderProfileResponseDto response =
                providerAuthService.updateProfile(providerId, request);

        return ResponseHandler.generateResponse(
                "Profile Updated Successfully.",
                HttpStatus.OK,
                response
        );
    }

    @GetMapping("/getProfile")
    public ResponseEntity<ApiResponse<ServiceProviderProfileResponseDto>> getProfile(
            Authentication authentication
    ){
        Long providerId = Long.parseLong(authentication.getName());

        ServiceProviderProfileResponseDto newProfile = providerAuthService.getProfileService(providerId);

        return ResponseHandler.generateResponse(
                "Profile fetch successfully",
                HttpStatus.OK,
                newProfile
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(
            Authentication authentication
    ){
        Long providerId = Long.parseLong(authentication.getName());
        providerAuthService.logout(providerId);
        return  ResponseHandler.generateResponse(
                "Logout Successfully",
                HttpStatus.OK,
                null
        );
    }
}
