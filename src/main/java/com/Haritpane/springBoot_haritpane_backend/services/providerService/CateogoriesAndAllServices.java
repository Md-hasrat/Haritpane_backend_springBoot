package com.Haritpane.springBoot_haritpane_backend.services.providerService;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CateogoriesAndAllServices {

    List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName);
    LandManagementResponseDto addLandManagementService(
            LandManagementRequestDto landManagementRequestDto,
            Authentication authentication
    );
}
