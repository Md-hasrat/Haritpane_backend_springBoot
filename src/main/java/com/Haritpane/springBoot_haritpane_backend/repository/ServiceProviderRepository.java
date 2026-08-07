package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.enums.ServiceProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceProviderRepository extends JpaRepository<ServiceProviderEntity, Long> {
    Optional<ServiceProviderEntity> findByEmail(String email);
    Optional<ServiceProviderEntity> findByPhone(String phone);

    Optional<ServiceProviderEntity> findByPhoneAndServiceProviderType(
            String phone,
            ServiceProviderType serviceProviderType
    );
}
