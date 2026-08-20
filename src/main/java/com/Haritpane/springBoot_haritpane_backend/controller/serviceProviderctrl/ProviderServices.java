package com.Haritpane.springBoot_haritpane_backend.controller.serviceProviderctrl;


import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/services")
public class ProviderServices {

    @Autowired
    private CateogoriesAndAllServices cateogoriesAndAllServices;

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List>> getAllCategories(
            @RequestParam(required = false) String categoryName
    ){
        List<ServiceCategoryEntity> ls = cateogoriesAndAllServices.getServicesByCategoryName(categoryName);

        return ResponseHandler.generateResponse(
                "Category fetched successfully",
                HttpStatus.OK,
                ls
        );
    }

    @PostMapping("/addLandManagementService")
    public ResponseEntity<ApiResponse<LandManagementResponseDto>> addlandService(
            @RequestBody LandManagementRequestDto landManagementRequestDto,
            Authentication authentication
            ){

        LandManagementResponseDto newLand = cateogoriesAndAllServices.addLandManagementService(
                landManagementRequestDto,
                authentication
        );

        if (newLand == null) {
            return ResponseHandler.generateResponse(
                    "Something went wrong",
                    HttpStatus.CONFLICT,
                    null
            );
        }

        return ResponseHandler.generateResponse(
                "Land Service added successfully",
                HttpStatus.CREATED,
                newLand
        );


    }
}
