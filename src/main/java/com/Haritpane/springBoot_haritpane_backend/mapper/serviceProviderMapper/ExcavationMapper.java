package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.ExcavationServiceRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.ExcavationServiceResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ExcavationService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = ServiceAvailabilityMapper.class
)
public interface ExcavationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "serviceProviderId", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    ExcavationService toEntity(ExcavationServiceRequestDto requestDto);


    @Mapping(
            target = "serviceProviderId",
            source = "serviceProviderId.id"
    )
    @Mapping(
            target = "categoryId",
            source = "categoryId.id"
    )
    ExcavationServiceResponseDto toResponseDto(ExcavationService entity);
}
