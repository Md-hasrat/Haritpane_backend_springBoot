package com.Haritpane.springBoot_haritpane_backend.entity;


import com.Haritpane.springBoot_haritpane_backend.enums.Day;
import com.Haritpane.springBoot_haritpane_backend.enums.Month;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Availability {

    @ElementCollection(targetClass = Day.class)
    @Enumerated(EnumType.STRING)
    private List<Day> selectedDay;
    @ElementCollection(targetClass = Month.class)
    @Enumerated(EnumType.STRING)
    private List<Month> selectedMonth;
    private Boolean isOpen24Hours;
    private Boolean isClosed;
    @ElementCollection(targetClass = TimeSlot.class)
    private List<TimeSlot> timeSlots;

}
