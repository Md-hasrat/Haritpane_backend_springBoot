package com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.enums.FarmerStatus;
import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;

public class FarmerProfileResponseDto {

    private Long id;
    private String fullName;
    private String phone;
    private String name;
    private String email;
    private String fullAddress;
    private Double[] location;
    private LanguagePreference languagePreference;
    private FarmerStatus farmerStatus;
    private Boolean pushNotification;
    private Boolean chatNotification;
    private String jwt;
}
