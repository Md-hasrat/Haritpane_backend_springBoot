package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.LandManagementRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.LandManagementResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = ServiceAvailabilityMapper.class
)
public interface LandManagementMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "serviceProviderId", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    LandManagementService toEntity(LandManagementRequestDto dto);

    LandManagementResponseDto toResponseDto(LandManagementService entity);
}