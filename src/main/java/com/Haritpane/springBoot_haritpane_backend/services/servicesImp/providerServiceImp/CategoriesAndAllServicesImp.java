//package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.providerServiceImp;
//
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ExcavationServiceRequestDto;
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.HarvesterRequestDto;
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ExcavationServiceResponseDto;
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.HarvesterResponseDto;
//import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
//import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
//import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
//import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ExcavationService;
//import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.HarvesterService;
//import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
//import com.Haritpane.springBoot_haritpane_backend.exception.BadRequestException;
//import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
//import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.ExcavationMapper;
//import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.HarvesterMapper;
//import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.LandManagementMapper;
//import com.Haritpane.springBoot_haritpane_backend.repository.*;
//import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CategoriesAndAllServicesImp implements CateogoriesAndAllServices {
//
//    private final ServiceCategoryRepository serviceCategoryRepository;
//    private final ServiceProviderRepository serviceProviderRepository;
//    private final LandManagementRepository landManagementRepository;
//    private final LandManagementMapper landManagementMapper;
//    private final HarvesterRepository harvesterRepository;
//    private final HarvesterMapper harvesterMapper;
//    private final ExcavationRespository excavationRespository;
//    private final ExcavationMapper excavationMapper;
//
//
//
//    @Override
//    public List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName) {
//        if (categoryName == null || categoryName.isBlank()) {
//            return serviceCategoryRepository.findAll();
//        }
//
//        return serviceCategoryRepository.findByName(categoryName);
//    }
//
//    @Override
//    public LandManagementResponseDto addLandManagementService(
//            LandManagementRequestDto landManagementRequestDto,
//            Authentication authentication
//    ) {
//        String providerId = authentication.getName();
//        ServiceProviderEntity provider = serviceProviderRepository.findById(Long.valueOf(providerId))
//                .orElseThrow(()->
//                        new ResourceNotFoundException("Service provider not found"));
//
//        if (landManagementRequestDto.getCategoryId() == null){
//            throw new RuntimeException("Category ID is required");
//        }
//
//        ServiceCategoryEntity category = serviceCategoryRepository.findById(landManagementRequestDto.getCategoryId())
//                .orElseThrow(()->
//                        new ResourceNotFoundException("Category not found"));
//        LandManagementService newEntity =  landManagementMapper.toEntity(landManagementRequestDto);
//        newEntity.setServiceProviderId(provider);
//        newEntity.setCategoryId(category);
//        LandManagementService savedEntity = landManagementRepository.save(newEntity);
//        return landManagementMapper.toResponseDto(savedEntity);
//    }
//
//    @Override
//    public HarvesterResponseDto addHarvesterService(
//            HarvesterRequestDto harvesterRequestDto,
//            Authentication authentication
//    ) {
//        String providerId = authentication.getName();
//        ServiceProviderEntity provider = serviceProviderRepository.findById(Long.valueOf(providerId))
//                .orElseThrow(()->
//                        new ResourceNotFoundException("Service provider not found"));
//
//        if (harvesterRequestDto.getCategoryId() == null){
//            throw new RuntimeException("Category ID is required");
//        }
//
//        ServiceCategoryEntity category = serviceCategoryRepository.findById(harvesterRequestDto.getCategoryId())
//                .orElseThrow(()->
//                        new ResourceNotFoundException("Category not found"));
//
//        System.out.println(
//                "DTO charges = " + harvesterRequestDto.getChargesPerAcre()
//        );
//
//
//        HarvesterService newEntity = harvesterMapper.toEntity(harvesterRequestDto);
//        newEntity.setServiceProviderId(provider);
//        newEntity.setCategoryId(category);
//        HarvesterService saveDEntity = harvesterRepository.save(newEntity);
//
//        return harvesterMapper.toResponse(saveDEntity);
//    }
//
//    @Override
//    public ExcavationServiceResponseDto addExcavationService(
//            ExcavationServiceRequestDto request,
//            Authentication authentication
//    ) {
//        if (request == null) {
//            throw new ResourceNotFoundException("Request body is required");
//        }
//        if (request.getCategoryId() == null) {
//            throw new ResourceNotFoundException("Category ID is required");
//        }
//
//        Long providerId;
//        try {
//            providerId = Long.valueOf(authentication.getName());
//        } catch (NumberFormatException ex) {
//            throw new BadRequestException("Invalid service provider identity");
//        }
//
//        ServiceProviderEntity provider = serviceProviderRepository.findById(providerId)
//                .orElseThrow(() -> new ResourceNotFoundException("Service provider not found"));
//
//        ServiceCategoryEntity category = serviceCategoryRepository.findById(request.getCategoryId())
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
//
//        ExcavationService entity = excavationMapper.toEntity(request);
//        entity.setServiceProviderId(provider);
//        entity.setCategoryId(category);
//
//        ExcavationService saved = excavationRespository.save(entity);
//        return excavationMapper.toResponseDto(saved);
//    }
//}


package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.providerServiceImp;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ElectroStaticSprayingRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ExcavationServiceRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.HarvesterRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ElectroStaticSprayingResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ExcavationServiceResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.HarvesterResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ElectroStaticSpraying;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ExcavationService;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.HarvesterService;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import com.Haritpane.springBoot_haritpane_backend.exception.BadRequestException;
import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.ElectroStaticSprayingMapper;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.ExcavationMapper;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.HarvesterMapper;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.LandManagementMapper;
import com.Haritpane.springBoot_haritpane_backend.repository.*;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesAndAllServicesImp implements CateogoriesAndAllServices {

    private final ServiceCategoryRepository serviceCategoryRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final LandManagementRepository landManagementRepository;
    private final HarvesterRepository harvesterRepository;
    private final ExcavationRespository excavationRespository;

    private final LandManagementMapper landManagementMapper;
    private final HarvesterMapper harvesterMapper;
    private final ExcavationMapper excavationMapper;
    private final ElectroStaticSprayingRepository electroStaticSprayingRepository;
    private final ElectroStaticSprayingMapper electroStaticSprayingMapper;

    @Override
    public List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) {
            return serviceCategoryRepository.findAll();
        }

        return serviceCategoryRepository.findByName(categoryName);
    }

    @Override
    public LandManagementResponseDto addLandManagementService(
            LandManagementRequestDto request,
            Authentication authentication
    ) {
        validateRequest(request == null, "Request body is required");
        validateRequest(request.getCategoryId() == null, "Category ID is required");

        ServiceProviderEntity provider = findProvider(authentication);
        ServiceCategoryEntity category = findCategory(request.getCategoryId());

        LandManagementService entity = landManagementMapper.toEntity(request);
        entity.setServiceProviderId(provider);
        entity.setCategoryId(category);

        LandManagementService saved = landManagementRepository.save(entity);
        return landManagementMapper.toResponseDto(saved);
    }

    @Override
    public HarvesterResponseDto addHarvesterService(
            HarvesterRequestDto request,
            Authentication authentication
    ) {
        validateRequest(request == null, "Request body is required");
        validateRequest(request.getCategoryId() == null, "Category ID is required");

        ServiceProviderEntity provider = findProvider(authentication);
        ServiceCategoryEntity category = findCategory(request.getCategoryId());

        HarvesterService entity = harvesterMapper.toEntity(request);
        entity.setServiceProviderId(provider);
        entity.setCategoryId(category);

        HarvesterService saved = harvesterRepository.save(entity);
        return harvesterMapper.toResponse(saved);
    }

    @Override
    public ExcavationServiceResponseDto addExcavationService(
            ExcavationServiceRequestDto request,
            Authentication authentication
    ) {
        validateRequest(request == null, "Request body is required");
        validateRequest(request.getCategoryId() == null, "Category ID is required");

        ServiceProviderEntity provider = findProvider(authentication);
        ServiceCategoryEntity category = findCategory(request.getCategoryId());

        ExcavationService entity = excavationMapper.toEntity(request);
        entity.setServiceProviderId(provider);
        entity.setCategoryId(category);

        ExcavationService saved = excavationRespository.save(entity);
        return excavationMapper.toResponseDto(saved);
    }

    @Override
    public ElectroStaticSprayingResponseDto addElectroStaticSpraying(
            ElectroStaticSprayingRequestDto request,
            Authentication authentication
    ) {
        validateRequest(request == null, "Request body is required");
        validateRequest(request.getCategoryId() == null, "Category ID is required");

        ServiceProviderEntity provider = findProvider(authentication);
        ServiceCategoryEntity category = findCategory(request.getCategoryId());

        ElectroStaticSpraying entity = electroStaticSprayingMapper.toEntity(request);
        entity.setServiceProviderId(provider);
        entity.setCategoryId(category);

        ElectroStaticSpraying saved = electroStaticSprayingRepository.save(entity);
        return electroStaticSprayingMapper.toResponseDto(saved);
    }

    private ServiceProviderEntity findProvider(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            throw new BadRequestException("Authenticated service provider is required");
        }

        Long providerId;
        try {
            providerId = Long.valueOf(authentication.getName());
        } catch (NumberFormatException ex) {
            throw new BadRequestException("Invalid service provider identity");
        }

        return serviceProviderRepository.findById(providerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Service provider not found"));
    }

    private @NonNull ServiceCategoryEntity findCategory(Long categoryId) {
        return serviceCategoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
    }

    private void validateRequest(boolean invalid, String message) {
        if (invalid) {
            throw new BadRequestException(message);
        }
    }


}
