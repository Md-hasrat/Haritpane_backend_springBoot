package com.Haritpane.springBoot_haritpane_backend.services.farmerService;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.LoginDto;

public interface FarmerAuthService {

    LoginDto login(String phone);

}
