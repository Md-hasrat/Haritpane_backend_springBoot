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

            provider = providerRepository.save(provider);
            isNewUser = true;
        }

        String token = jwtService.generateToken(
                provider.getId(),
                provider.getServiceProviderType().name());

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

        provider = providerRepository.save(provider);

        return serviceProviderReqMap.toDto(provider);
    }
}
