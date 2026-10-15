package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LocationDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceAvailabilityDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ElectroStaticSprayingResponseDto {

    private Long id;

    private Long serviceProviderId;

    private Long categoryId;

    private LocationDto location;

    private String chargesPerAcre;

    private String radiusOfWork;

    private String additionalTransportationCharge;

    private String numberOfEquipments;

    private String equipmentImg;

    private ServiceAvailabilityDto serviceAvailability;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
