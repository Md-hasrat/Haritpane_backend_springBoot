package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.EquipmentType;
import com.Haritpane.springBoot_haritpane_backend.enums.PriceBasis;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "excavation_service")
@EntityListeners(AuditingEntityListener.class)
public class ExcavationService {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProviderEntity serviceProviderId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ServiceCategoryEntity categoryId;

    @Embedded
    private Location location;
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;
    @Enumerated(EnumType.STRING)
    private PriceBasis priceBasis;
    private String price;
    private String radiusOfWork;
    private String additionalCharges;
    private Integer numberOfEquipment;
    private String equipmentImg;

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
