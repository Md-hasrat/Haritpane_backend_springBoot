package com.Haritpane.springBoot_haritpane_backend.mapper.serviceProviderMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.serviceProviderDto.BusinessInfoDto;
import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.BusinessInfo;

public interface BusinessInfoMapper {

    BusinessInfo toEntity(BusinessInfoDto dto);

    BusinessInfoDto toDto(BusinessInfo entity);
}
