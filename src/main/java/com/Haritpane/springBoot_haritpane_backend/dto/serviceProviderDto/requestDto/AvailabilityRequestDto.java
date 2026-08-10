package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.TimeSlotDto;
import com.Haritpane.springBoot_haritpane_backend.enums.Day;
import com.Haritpane.springBoot_haritpane_backend.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityRequestDto {

    private List<Day> selectedDay;

    private List<Month> selectedMonth;

    private Boolean isOpen24Hours;

    private Boolean isClosed;

    private List<TimeSlotDto> timeSlots;
}
