package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ElectroStaticSprayingRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ElectroStaticSprayingResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ElectroStaticSpraying;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = ServiceAvailabilityMapper.class
)
public interface ElectroStaticSprayingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "serviceProviderId", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    ElectroStaticSpraying toEntity(ElectroStaticSprayingRequestDto requestDto);

    @Mapping(target = "serviceProviderId", source = "serviceProviderId.id")
    @Mapping(target = "categoryId", source = "categoryId.id")
    ElectroStaticSprayingResponseDto toResponseDto(ElectroStaticSpraying entity);
}
