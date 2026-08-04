package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class BusinessInfo {
    private  String businessName;
    private String businessEmail;
    private String buildingName;
    private String street;
    private String city;
    private String state;
    private  String pinCode;
}
