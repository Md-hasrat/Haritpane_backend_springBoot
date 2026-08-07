package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.AvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.BusinessInfoDto;
import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
import com.Haritpane.springBoot_haritpane_backend.enums.ProviderStatus;
import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderProfileResponseDto {

    private Long providerId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String profilePic;

    private Boolean pushNotification;
    private Boolean whatsAppNotification;

    private ServiceProviderType serviceProviderType;

    private String whatsAppNumber;
    private ProviderStatus providerStatus;

    private BusinessInfoDto businessInfo;

    private Boolean haveGst;
    private String gstNumber;
    private String panCard;
    private Boolean isNewUser;
    private String token;

    private LanguagePreference languagePreference;

    private AvailabilityDto availability;
}
