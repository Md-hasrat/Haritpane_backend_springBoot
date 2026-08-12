package com.Haritpane.springBoot_haritpane_backend.mapper.farmerMapper;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.requestDto.FarmerUpdateProfileDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.FarmerProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity.FarmerEntity;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface FarmerMapper {

    void updateEntity(
            FarmerUpdateProfileDto dto,
            @MappingTarget FarmerEntity entity
    );

    @Mapping(source = "id", target = "farmerId")
    FarmerProfileResponseDto toDto(FarmerEntity entity);
}
