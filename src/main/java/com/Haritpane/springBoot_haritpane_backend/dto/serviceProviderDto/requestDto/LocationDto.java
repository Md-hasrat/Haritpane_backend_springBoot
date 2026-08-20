package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private String address;

    private Double latitude;

    private Double longitude;
}