package com.Haritpane.springBoot_haritpane_backend.services;

import com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity.FarmerEntity;
import com.Haritpane.springBoot_haritpane_backend.repository.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmerUserDetailsService implements UserDetailsService {

    private final FarmerRepository farmerRepository;

    @Override
    public UserDetails loadUserByUsername(String farmerId)
            throws UsernameNotFoundException {

        FarmerEntity farmer = farmerRepository
                .findById(Long.parseLong(farmerId))
                .orElseThrow(() ->
                        new UsernameNotFoundException("Farmer not found"));

        return User.builder()
                .username(farmer.getId().toString())
                .password(
                        farmer.getPassword() == null
                                ? ""
                                : farmer.getPassword()
                )
                .authorities("ROLE_FARMER")
                .build();
    }
}