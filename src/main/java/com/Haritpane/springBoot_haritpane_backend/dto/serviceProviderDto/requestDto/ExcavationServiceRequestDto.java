package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;


import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.Location;
import com.Haritpane.springBoot_haritpane_backend.enums.EquipmentType;
import com.Haritpane.springBoot_haritpane_backend.enums.PriceBasis;
import lombok.Data;

@Data
public class ExcavationServiceRequestDto {

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
}
