package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.HarvesterRequestDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.responseDto.HarvesterResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.HarvesterService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(
        componentModel = "spring",
        uses = ServiceAvailabilityMapper.class
)
public interface HarvesterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "serviceProviderId", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    HarvesterService toEntity(HarvesterRequestDto harvesterRequestDto);

    @Mapping(
            target = "serviceProviderId",
            source = "serviceProviderId.id"
    )
    @Mapping(
            target = "categoryId",
            source = "categoryId.id"
    )
    HarvesterResponseDto toResponse(HarvesterService entity);
}
