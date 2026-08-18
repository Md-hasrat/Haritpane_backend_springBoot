package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceAvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.enums.*;
import lombok.Data;

@Data
public class LandManagementResponseDto {

    private Long id;

    private Long serviceProviderId;

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
