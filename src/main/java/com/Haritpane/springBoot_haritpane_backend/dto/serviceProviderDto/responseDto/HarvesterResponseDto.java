package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LocationDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceAvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.enums.HarvesterSubCategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HarvesterResponseDto {

    private Long id;

    private Long serviceProviderId;

    private Long categoryId;

    private HarvesterSubCategory subCategory;

    private String equipmentType;

    private String equipmentModel;

    private LocationDto location;

    private String radiusOfWork;

    private String additionalCharge;

    private String cropType;

    private String chargesPerAcr;

    private String harvesterImg;

    private String harvesterModelName;

    private String HarvesterManufacturer;

    private ServiceAvailabilityDto serviceAvailability;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
