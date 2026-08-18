package com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeSlotDto {

    private LocalTime openTime;

    private LocalTime closeTime;
}