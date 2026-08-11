package com.Haritpane.springBoot_haritpane_backend.mapper.farmerMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.FarmerProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity.FarmerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface FarmerMapper {

    @Mapping(source = "id", target = "farmerId")
    FarmerProfileResponseDto toDto(FarmerEntity entity);
}
