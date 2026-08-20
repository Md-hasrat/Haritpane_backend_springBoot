package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName;


import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "land_management_service")
public class LandManagementService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_provider_id",nullable = false)
    private ServiceProviderEntity serviceProviderId;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ServiceCategoryEntity categoryId;

    @Enumerated(EnumType.STRING)
    private LandManagementSubcategory selectedSubCategory;
    @Enumerated(EnumType.STRING)
    private BrandOfTractor selectedBrandOfTractor;
    private String modelOfTractor;
    @Enumerated(EnumType.STRING)
    private HpOfTractor hpOfTractor;
    @Enumerated(EnumType.STRING)
    private PriceBasis priceBasis;
    private String price;
    @Enumerated(EnumType.STRING)
    private EquipmentInformation equipmentInformation;
    private String equipmentDetails;
    private String radiusOfWork;
    private String additionalCharge;

    private Integer numberOfProduct;
    private String uploadImage;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "availability_id")
    private ServiceAvailability serviceAvailability;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
