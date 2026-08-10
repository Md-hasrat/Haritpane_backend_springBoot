package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoRequestDto {

    private String businessName;
    private String businessEmail;
    private String buildingName;
    private String street;
    private String city;
    private String state;
    private String pinCode;
}