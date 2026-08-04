package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto;

import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderRequestDto {

    private String name;
    private String phone;
    private String email;
    private String address;
    private String profilePic;

    private Boolean pushNotification;
    private Boolean whatsAppNotification;

    private ServiceProviderType serviceProviderType;

    private String whatsAppNumber;

    private BusinessInfoDto businessInfo;

    private Boolean haveGst;
    private String gstNumber;
    private String panCard;

    private LanguagePreference languagePreference;

    private AvailabilityDto availability;
}
