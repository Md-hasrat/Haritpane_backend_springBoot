package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity;


import com.Haritpane.springBoot_haritpane_backend.entity.Availability;
import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import com.Haritpane.springBoot_haritpane_backend.enums.ProviderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ServiceProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String profilePic;
    private Boolean pushNotification;
    private Boolean whatsAppNotification;
    private String password;
    private String otp;
    private LocalDateTime otpExpiry;
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_provider_type")
    private ServiceProviderType serviceProviderType;
    private String whatsAppNumber;

    @Embedded
    private BusinessInfo businessInfo;
    private Boolean haveGst;
    private String gstNumber;
    private String panCard;
    @Enumerated(EnumType.STRING)
    @Column(name = "language_preference")
    private LanguagePreference languagePreference;

    @Enumerated(EnumType.STRING)
    @Column(name = "providerStatus")
    private ProviderStatus providerStatus;

    @Embedded
    private Availability availability;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
