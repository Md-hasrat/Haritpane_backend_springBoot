package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotDto {
    private String startTime;

    private String endTime;
}
