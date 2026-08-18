package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.TimeSlotDto;
import com.Haritpane.springBoot_haritpane_backend.enums.Day;
import com.Haritpane.springBoot_haritpane_backend.enums.Month;
import lombok.Data;

import java.util.List;

@Data
public class ServiceAvailabilityDto {

    private List<Day> selectedDays;

    private List<Month> selectedMonths;

    private Boolean open24Hours;

    private Boolean closed;

    private List<TimeSlotDto> timeSlots;
}