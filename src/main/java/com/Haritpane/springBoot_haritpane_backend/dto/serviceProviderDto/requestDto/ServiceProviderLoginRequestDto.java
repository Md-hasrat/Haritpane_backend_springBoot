package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;


import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProviderLoginRequestDto {

    private String phone;
    private ServiceProviderType serviceProviderType;


}
