package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.HarvesterSubCategory;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class HarvesterService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProviderEntity serviceProviderId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ServiceCategoryEntity categoryId;

    @Enumerated(EnumType.STRING)
    private HarvesterSubCategory subCategory;
    private String equipmentType;
    private String equipmentModel;
    @Embedded
    private Location location;
    private String radiusOfWork;
    private String additionalCharge;
    private String cropType;
    private String chargesPerAcre;
    private String harvesterImg;
    private String harvesterModelName;
    private String harvesterManufacturer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "availability_id")
    private ServiceAvailability serviceAvailability;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
