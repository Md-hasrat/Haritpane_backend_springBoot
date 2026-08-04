package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.TimeSlotDto;
import com.Haritpane.springBoot_haritpane_backend.entity.TimeSlot;

public interface TimeSlotMapper {
    TimeSlot toEntity(TimeSlotDto dto);

    TimeSlotDto toDto(TimeSlot entity);
}
