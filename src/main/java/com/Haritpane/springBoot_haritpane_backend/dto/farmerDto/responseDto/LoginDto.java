package com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto;

import com.Haritpane.springBoot_haritpane_backend.enums.FarmerStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class LoginDto {

    private Long farmerId;
    private String jwt;
    private FarmerStatus farmerStatus;
    private Boolean isNewUser;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

}
