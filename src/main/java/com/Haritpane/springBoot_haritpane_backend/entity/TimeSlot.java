package com.Haritpane.springBoot_haritpane_backend.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalTime;

@Data
@Embeddable
public class TimeSlot {
    private LocalTime startTime;

    private LocalTime endTime;
}
