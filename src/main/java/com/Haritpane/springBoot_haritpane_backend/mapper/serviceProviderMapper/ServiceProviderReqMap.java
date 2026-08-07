package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ServiceProviderUpdateProfileRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ServiceProviderProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(
        componentModel = "spring",
        uses = {
                BusinessInfoMapper.class,
                AvailabilityMapper.class,
                TimeSlotMapper.class
        }
)
public interface ServiceProviderReqMap {

    ServiceProviderEntity toEntity(ServiceProviderUpdateProfileRequestDto dto);

    @Mapping(source = "id", target = "providerId")
    ServiceProviderProfileResponseDto toDto(ServiceProviderEntity entity);
}
