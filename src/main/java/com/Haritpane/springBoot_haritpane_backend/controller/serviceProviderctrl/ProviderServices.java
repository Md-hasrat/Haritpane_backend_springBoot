package com.Haritpane.springBoot_haritpane_backend.controller.serviceProviderctrl;


import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import com.Haritpane.springBoot_haritpane_backend.util.ApiResponse;
import com.Haritpane.springBoot_haritpane_backend.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
