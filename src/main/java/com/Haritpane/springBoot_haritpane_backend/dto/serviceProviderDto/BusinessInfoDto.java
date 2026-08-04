package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoDto {

    private String businessName;
    private String businessPhone;
    private String businessEmail;
    private String businessAddress;
    private String website;
}
