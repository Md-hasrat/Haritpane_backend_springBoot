package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.TimeSlotDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceAvailabilityDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.TimeSlot;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ServiceAvailability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceAvailabilityMapper {

    ServiceAvailability toEntity(ServiceAvailabilityDto dto);

    ServiceAvailabilityDto toDto(ServiceAvailability entity);


    TimeSlot toEntity(TimeSlotDto dto);

    TimeSlotDto toDto(TimeSlot entity);

}
