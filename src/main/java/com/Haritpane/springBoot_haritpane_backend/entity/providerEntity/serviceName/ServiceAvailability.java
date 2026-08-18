package com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName;

import com.Haritpane.springBoot_haritpane_backend.enums.Day;
import com.Haritpane.springBoot_haritpane_backend.enums.Month;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "service_availability")
public class ServiceAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name = "service_available_days",
            joinColumns = @JoinColumn(name = "availability_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private List<Day> selectedDays = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "service_available_months",
            joinColumns = @JoinColumn(name = "availability_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "month")
    private List<Month> selectedMonths = new ArrayList<>();

    private Boolean open24Hours = false;

    private Boolean closed = false;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "availability_id")
    private List<TimeSlot> timeSlots = new ArrayList<>();
}
