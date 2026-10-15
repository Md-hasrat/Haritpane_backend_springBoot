package com.Haritpane.springBoot_haritpane_backend.controller.serviceProviderctrl;


import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ExcavationServiceRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.HarvesterRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ExcavationServiceResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.HarvesterResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ExcavationService;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ElectroStaticSprayingRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ElectroStaticSprayingResponseDto;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
            log.debug("SomeThing went wrong");
            return ResponseHandler.generateResponse(
                    "Something went wrong",
                    HttpStatus.CONFLICT,
                    null
            );
        }

        log.info("Land management service added");
        return ResponseHandler.generateResponse(
                "Land Service added successfully",
                HttpStatus.CREATED,
                newLand
        );
    }

    @PostMapping("/addHarvester")
    public  ResponseEntity<ApiResponse<HarvesterResponseDto>> addHarvester(
            @RequestBody HarvesterRequestDto harvesterRequestDto,
            Authentication authentication
            ){
        HarvesterResponseDto newHar = cateogoriesAndAllServices.addHarvesterService(
                harvesterRequestDto,
                authentication);
        if (newHar == null) {
            return ResponseHandler.generateResponse(
                    "Something went wrong",
                    HttpStatus.CONFLICT,
                    null
            );
        }

        return ResponseHandler.generateResponse(
                "Land Service added successfully",
                HttpStatus.CREATED,
                newHar
        );
    }

    @PostMapping("addExcavation")
    public ResponseEntity<ApiResponse<ExcavationServiceResponseDto>> addExcavation(
            @RequestBody ExcavationServiceRequestDto excavationServiceRequestDto,
            Authentication authentication
            ){
        ExcavationServiceResponseDto newRes = cateogoriesAndAllServices.addExcavationService(
                excavationServiceRequestDto,
                authentication
        );
        if(newRes==null){
            return ResponseHandler.generateResponse(
                    "Something went wrong",
                    HttpStatus.CONFLICT,
                    null
            );
        }
        return ResponseHandler.generateResponse(
                "Excavation service Created successfully.",
                HttpStatus.CREATED,
                newRes
        );
    }

    @PostMapping("/addElectroStaticSpraying")
    public ResponseEntity<ApiResponse<ElectroStaticSprayingResponseDto>>
    addElectroStaticSpraying(
            @RequestBody ElectroStaticSprayingRequestDto request,
            Authentication authentication
    ) {
        ElectroStaticSprayingResponseDto result =
                cateogoriesAndAllServices.addElectroStaticSpraying(request, authentication);

        if (result == null) {
            return ResponseHandler.generateResponse(
                    "Something went wrong",
                    HttpStatus.CONFLICT,
                    null
            );
        }


        return ResponseHandler.generateResponse(
                "Electrostatic spraying service added successfully",
                HttpStatus.CREATED,
                result
        );
    }


}
