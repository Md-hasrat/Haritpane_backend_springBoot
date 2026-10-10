package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LocationDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceAvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.enums.EquipmentType;
import com.Haritpane.springBoot_haritpane_backend.enums.PriceBasis;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ExcavationServiceResponseDto {

    private Long id;

    private Long serviceProviderId;

    private Long categoryId;

    private LocationDto location;

    private EquipmentType equipmentType;

    private PriceBasis priceBasis;

    private String price;

    private String radiusOfWork;

    private String additionalCharges;

    private Integer numberOfEquipment;

    private String equipmentImg;

    private ServiceAvailabilityDto serviceAvailability;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
