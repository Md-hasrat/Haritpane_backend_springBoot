package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Location {

    private String address;

    private Double latitude;

    private Double longitude;
}
