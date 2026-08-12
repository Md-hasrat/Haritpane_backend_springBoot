    package com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.requestDto;

    import com.Haritpane.springBoot_haritpane_backend.enums.FarmerStatus;
    import com.Haritpane.springBoot_haritpane_backend.enums.LanguagePreference;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    public class FarmerUpdateProfileDto {

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
    }
