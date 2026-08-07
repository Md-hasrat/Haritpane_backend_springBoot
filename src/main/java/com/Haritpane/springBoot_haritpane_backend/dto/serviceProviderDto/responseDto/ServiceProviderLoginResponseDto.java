package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ServiceProviderLoginResponseDto {

    private Long providerId;
    private String token;
    private Boolean isNewUser;
    private String phone;
    private ServiceProviderType serviceProviderType;
}
