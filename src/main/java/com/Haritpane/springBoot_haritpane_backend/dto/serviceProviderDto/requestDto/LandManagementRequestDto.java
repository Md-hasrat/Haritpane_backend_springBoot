package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import com.Haritpane.springBoot_haritpane_backend.enums.*;
import lombok.Data;

@Data
public class LandManagementRequestDto {

    private Long categoryId;

    private LandManagementSubcategory selectedSubCategory;

    private BrandOfTractor selectedBrandOfTractor;

    private String modelOfTractor;

    private HpOfTractor hpOfTractor;

    private PriceBasis priceBasis;

    private String price;

    private EquipmentInformation equipmentInformation;

    private String equipmentDetails;

    private String radiusOfWork;

    private String additionalCharge;

    private Integer numberOfProduct;

    private String uploadImage;

    private ServiceAvailabilityDto serviceAvailability;
}