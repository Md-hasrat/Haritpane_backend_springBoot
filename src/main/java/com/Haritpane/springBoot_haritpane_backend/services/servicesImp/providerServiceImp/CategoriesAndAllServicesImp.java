package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.providerServiceImp;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.LandManagementMapper;
import com.Haritpane.springBoot_haritpane_backend.repository.LandManagementRepository;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceCategoryRepository;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceProviderRepository;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesAndAllServicesImp implements CateogoriesAndAllServices {

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;
    @Autowired
    private LandManagementRepository landManagementRepository;
    @Autowired
    private LandManagementMapper landManagementMapper;



    @Override
    public List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) {
            return serviceCategoryRepository.findAll();
        }

        return serviceCategoryRepository.findByName(categoryName);
    }

    @Override
    public LandManagementResponseDto addLandManagementService(
            LandManagementRequestDto landManagementRequestDto,
            Authentication authentication
    ) {
        String providerId = authentication.getName();
        ServiceProviderEntity provider = serviceProviderRepository.findById(Long.valueOf(providerId))
                .orElseThrow(()->
                        new ResourceNotFoundException("Service provider not found"));

        if (landManagementRequestDto.getCategoryId() == null){
            throw new RuntimeException("Category ID is required");
        }

        ServiceCategoryEntity category = serviceCategoryRepository.findById(landManagementRequestDto.getCategoryId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Category not found"));
        LandManagementService newEntity =  landManagementMapper.toEntity(landManagementRequestDto);
        newEntity.setServiceProviderId(provider);
        newEntity.setCategoryId(category);
        LandManagementService savedEntity = landManagementRepository.save(newEntity);
        return landManagementMapper.toResponseDto(savedEntity);
    }
}
