package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.farmerEntity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<FarmerEntity, Long> {

    Optional<FarmerEntity> findByPhone(String phone);
}
