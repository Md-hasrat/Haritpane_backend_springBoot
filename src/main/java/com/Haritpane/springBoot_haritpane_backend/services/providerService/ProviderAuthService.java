package com.Haritpane.springBoot_haritpane_backend.services.providerService;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderLoginRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderUpdateProfileRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderLoginResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderProfileResponseDto;

public interface ProviderAuthService {
    ServiceProviderLoginResponseDto loginServiceProvider(ServiceProviderLoginRequestDto request);
    ServiceProviderProfileResponseDto updateProfile(
            Long providerId,
            ServiceProviderUpdateProfileRequestDto request
    );

    ServiceProviderProfileResponseDto getProfileService(Long providerId);

    void logout(Long providerId);


}
