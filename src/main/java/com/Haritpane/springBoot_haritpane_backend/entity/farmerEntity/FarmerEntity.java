package com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity;


import com.Haritpane.springBoot_haritpane_backend.enums.FarmerStatus;
import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
import jakarta.persistence.*;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;


@Data
@Entity
public class FarmerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
    private String name;
    private String email;
    private String password;

    private String fullAddress;
    @Column(columnDefinition = "double precision[]")
    private Double[] location;

    @Enumerated(EnumType.STRING)
    @Column(name = "farmerSelectedlanguage")
    private LanguagePreference languagePreference;

    @Enumerated(EnumType.STRING)
    @Column(name = "farmerStatus")
    private FarmerStatus farmerStatus = FarmerStatus.ACTIVE;

    private String jwt;
    private Boolean pushNotification;
    private Boolean chatNotification;
    private Boolean isNewUser;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;




}
