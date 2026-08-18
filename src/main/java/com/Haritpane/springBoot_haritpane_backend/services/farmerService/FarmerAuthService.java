package com.Haritpane.springBoot_haritpane_backend.services.farmerService;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.requestDto.FarmerUpdateProfileDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.FarmerProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.LoginDto;

public interface FarmerAuthService {

    LoginDto login(String phone);
    FarmerProfileResponseDto updateProfile(
            Long farmerId,
            FarmerUpdateProfileDto farmerUpdateProfileDto
    );

    FarmerProfileResponseDto getProfile(Long farmerId);
    void logout(Long farmerId);

}
