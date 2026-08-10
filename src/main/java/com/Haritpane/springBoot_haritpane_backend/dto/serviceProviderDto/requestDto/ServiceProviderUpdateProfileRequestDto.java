package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProviderUpdateProfileRequestDto {

    private String name;
    private String email;
    private String address;
    private String profilePic;

    private Boolean pushNotification;
    private Boolean whatsAppNotification;

    private String whatsAppNumber;

    private BusinessInfoRequestDto businessInfo;

    private Boolean haveGst;
    private String gstNumber;
    private String panCard;

    private LanguagePreference languagePreference;

    private AvailabilityRequestDto availability;
}