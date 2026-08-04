package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.ServiceProviderRequestDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import org.mapstruct.Mapper;


@Mapper(
        componentModel = "spring",
        uses = {
                BusinessInfoMapper.class,
                AvailabilityMapper.class,
                TimeSlotMapper.class
        }
)
public interface ServiceProviderReqMap {
    ServiceProviderEntity toEntity(ServiceProviderRequestDto dto);

    ServiceProviderRequestDto toDto(ServiceProviderEntity entity);
}
