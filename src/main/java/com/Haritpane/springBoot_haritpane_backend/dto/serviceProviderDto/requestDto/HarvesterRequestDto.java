package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import com.Haritpane.springBoot_haritpane_backend.enums.HarvesterSubCategory;
import lombok.Data;


@Data
public class HarvesterRequestDto {

    private Long categoryId;

    private HarvesterSubCategory subCategory;

    private String equipmentType;

    private String equipmentModel;

    private LocationDto location;

    private String radiusOfWork;

    private String additionalCharge;

    private String cropType;

    private String chargesPerAcre;

    private String harvesterImg;

    private String harvesterModelName;

    private String HarvesterManufacturer;

    private ServiceAvailabilityDto serviceAvailability;
}
