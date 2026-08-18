package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.LandManagementService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandManagementRepository extends JpaRepository<LandManagementService,Long> {
}
