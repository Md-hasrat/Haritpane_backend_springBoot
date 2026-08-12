package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.farmerServiceImp;

import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.requestDto.FarmerUpdateProfileDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.FarmerProfileResponseDto;
import com.Haritpane.springBoot_haritpane_backend.dto.farmerDto.responseDto.LoginDto;
import com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity.FarmerEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.FarmerStatus;
import com.Haritpane.springBoot_haritpane_backend.exception.ResourceNotFoundException;
import com.Haritpane.springBoot_haritpane_backend.mapper.farmerMapper.FarmerMapper;
import com.Haritpane.springBoot_haritpane_backend.repository.FarmerRepository;
import com.Haritpane.springBoot_haritpane_backend.security.JwtService;
import com.Haritpane.springBoot_haritpane_backend.services.farmerService.FarmerAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FarmerAuthServiceImp implements FarmerAuthService {

    private final FarmerRepository farmerRepository;
    private final JwtService jwtService;
    private final FarmerMapper farmerMapper;


    @Override
    public LoginDto login(String phone) {
        Optional<FarmerEntity>  optionalFarmer = farmerRepository.findByPhone(phone);

        System.out.println("Phone received in service: [" + phone + "]");

        FarmerEntity farmerEntity;
        boolean isNewUser;

        if (optionalFarmer.isPresent()) {
            farmerEntity = optionalFarmer.get();
            isNewUser = false;
        }else {
            farmerEntity = new FarmerEntity();
            farmerEntity.setPhone(phone);
//            farmerEntity.setFarmerStatus(FarmerStatus.ACTIVE);
            farmerEntity.setCreateAt(LocalDateTime.now());
            isNewUser = true;

            farmerEntity = farmerRepository.save(farmerEntity);
        }

        farmerEntity.setUpdatedAt(LocalDateTime.now());
        String token = jwtService.generateToken(
                farmerEntity.getId()
        );

        farmerEntity.setJwt(token);

        farmerRepository.save(farmerEntity);

        return LoginDto.builder()
                .farmerId(farmerEntity.getId())
                .jwt(token)
                .farmerStatus(farmerEntity.getFarmerStatus())
                .isNewUser(isNewUser)
                .createAt(farmerEntity.getCreateAt())
                .updatedAt(farmerEntity.getUpdatedAt())
                .build();
    }

    @Override
    public FarmerProfileResponseDto updateProfile(Long farmerId, FarmerUpdateProfileDto farmerUpdateProfileDto) {
        FarmerEntity farmer = farmerRepository.findById(farmerId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Farmer not found"));

        farmerMapper.updateEntity(farmerUpdateProfileDto, farmer);
        FarmerEntity updatedFarmer = farmerRepository.save(farmer);

        return farmerMapper.toDto(updatedFarmer);
    }

    @Override
    public FarmerProfileResponseDto getProfile(Long farmerId) {

        FarmerEntity response = farmerRepository.findById(farmerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Farmer not found"));
        return farmerMapper.toDto(response);
    }
}
