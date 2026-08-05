package com.Haritpane.springBoot_haritpane_backend.entity;


import com.Haritpane.springBoot_haritpane_backend.enums.Day;
import com.Haritpane.springBoot_haritpane_backend.enums.Month;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Availability {

    @ElementCollection(targetClass = Day.class)
    @CollectionTable(
            name = "provider_available_days",
            joinColumns = @JoinColumn(name = "provider_id")
    )
    @Enumerated(EnumType.STRING)
    private List<Day> selectedDay;

    @ElementCollection(targetClass = Month.class)
    @CollectionTable(
            name = "provider_available_months",
            joinColumns =  @JoinColumn(name = "provider_id")
    )
    @Enumerated(EnumType.STRING)
    private List<Month> selectedMonth;

    private Boolean isOpen24Hours;
    private Boolean isClosed;

    @ElementCollection(targetClass = TimeSlot.class)
    @CollectionTable(
            name = "provider_time_slots",
            joinColumns = @JoinColumn(name = "provider_id")
    )
    private List<TimeSlot> timeSlots;

}
