package com.Haritpane.springBoot_haritpane_backend.services;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ServiceProviderRepository serviceProviderRepository;

    @Override
    public UserDetails loadUserByUsername(String providerId)
            throws UsernameNotFoundException {

        ServiceProviderEntity serviceProvider = serviceProviderRepository
                .findById(Long.parseLong(providerId))
                .orElseThrow(() ->
                        new UsernameNotFoundException("Service Provider not found"));

        return User.builder()
                .username(serviceProvider.getId().toString()) // <-- ID
                .password(serviceProvider.getPassword() == null ? "" : serviceProvider.getPassword())
                .authorities("ROLE_PROVIDER")
                .build();
    }
}