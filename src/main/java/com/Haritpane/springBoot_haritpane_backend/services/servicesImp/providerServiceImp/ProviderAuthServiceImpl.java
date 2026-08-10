package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.providerServiceImp;


import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderLoginRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderUpdateProfileRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.ProviderStatus;
import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.AvailabilityMapper;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.BusinessInfoMapper;
import com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper.ServiceProviderReqMap;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceProviderRepository;
import com.Haritpane.springBoot_haritpane_backend.security.JwtService;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.ProviderAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProviderAuthServiceImpl implements ProviderAuthService {

    private final ServiceProviderRepository providerRepository;
    private final ServiceProviderReqMap serviceProviderReqMap;
    private final JwtService jwtService;
    private final BusinessInfoMapper businessInfoMapper;
    private final AvailabilityMapper availabilityMapper;

    @Override
    public ServiceProviderLoginResponseDto loginServiceProvider(
            ServiceProviderLoginRequestDto request) {

        Optional<ServiceProviderEntity> optionalServiceProvider =
                providerRepository.findByPhoneAndServiceProviderType(
                        request.getPhone(),
                        request.getServiceProviderType());

        ServiceProviderEntity provider;
        boolean isNewUser;

        if (optionalServiceProvider.isPresent()) {

            provider = optionalServiceProvider.get();
            isNewUser = false;

        } else {

            provider = new ServiceProviderEntity();
            provider.setPhone(request.getPhone());
            provider.setServiceProviderType(request.getServiceProviderType());
            provider.setProviderStatus(ProviderStatus.ACTIVE);

            // Set creation timestamp
            provider.setCreateAt(LocalDateTime.now());

            provider = providerRepository.save(provider);
            isNewUser = true;
        }

        // Always update the updatedAt timestamp
        provider.setUpdatedAt(LocalDateTime.now());

        String token = jwtService.generateToken(
                provider.getId(),
                provider.getServiceProviderType().name());
        // Save token
        provider.setToken(token);

        providerRepository.save(provider);

        return ServiceProviderLoginResponseDto.builder()
                .providerId(provider.getId())
                .phone(provider.getPhone())
                .serviceProviderType(provider.getServiceProviderType())
                .token(token)
                .isNewUser(isNewUser)
                .build();
    }

    @Override
    public ServiceProviderProfileResponseDto updateProfile(Long providerId, ServiceProviderUpdateProfileRequestDto request) {

        ServiceProviderEntity provider = providerRepository.findById(providerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Service Provider not found"));

        // Update fields
        provider.setName(request.getName());
        provider.setEmail(request.getEmail());
        provider.setAddress(request.getAddress());
        provider.setProfilePic(request.getProfilePic());

        provider.setPushNotification(request.getPushNotification());
        provider.setWhatsAppNotification(request.getWhatsAppNotification());

        provider.setWhatsAppNumber(request.getWhatsAppNumber());

        provider.setHaveGst(request.getHaveGst());
        provider.setGstNumber(request.getGstNumber());
        provider.setPanCard(request.getPanCard());

        provider.setLanguagePreference(request.getLanguagePreference());

        // Business Info
        if (request.getBusinessInfo() != null) {
            provider.setBusinessInfo(
                    businessInfoMapper.toEntity(request.getBusinessInfo())
            );
        }

        if (request.getAvailability() != null) {
            provider.setAvailability(
                    availabilityMapper.toEntity(request.getAvailability())
            );
        }

        System.out.println("Entity before updatedAt = " + provider.getUpdatedAt());

        // Update timestamp
        provider.setUpdatedAt(LocalDateTime.now());

        System.out.println("Entity  AFTER updatedAt = " + provider.getUpdatedAt());

        provider = providerRepository.save(provider);
        System.out.println("This is updated user"+ provider);

        ServiceProviderProfileResponseDto dto = serviceProviderReqMap.toDto(provider);

        System.out.println("DTO = " + dto);

        return serviceProviderReqMap.toDto(provider);
    }

    @Override
    public ServiceProviderProfileResponseDto getProfileService(Long providerId) {

        ServiceProviderEntity provider = providerRepository.findById(providerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Service Provider not found"));
        ServiceProviderProfileResponseDto newProvider = serviceProviderReqMap.toDto(provider);
        return newProvider;
    }

    @Override
    public void logout(Long providerId) {

        ServiceProviderEntity newProvider = providerRepository.findById(providerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Provider not found"));

        newProvider.setUpdatedAt(LocalDateTime.now());
        newProvider.setToken(null);
        providerRepository.save(newProvider);
    }
}
