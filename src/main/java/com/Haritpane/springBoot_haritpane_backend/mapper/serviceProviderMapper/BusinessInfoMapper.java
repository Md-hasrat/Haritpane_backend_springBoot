package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.BusinessInfoDto;
import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.requestDto.BusinessInfoRequestDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.BusinessInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessInfoMapper {

    BusinessInfo toEntity(BusinessInfoRequestDto dto);

    BusinessInfoDto toDto(BusinessInfo entity);
}