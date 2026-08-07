package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.AvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.entity.Availability;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    Availability toEntity(AvailabilityDto dto);

    AvailabilityDto toDto(Availability entity);
}
