package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import lombok.Data;

@Data
public class ElectroStaticSprayingRequestDto {

    private Long categoryId;

    private LocationDto location;

    private String chargesPerAcre;

    private String radiusOfWork;

    private String additionalTransportationCharge;

    private String numberOfEquipments;

    private String equipmentImg;

    private ServiceAvailabilityDto serviceAvailability;
}
