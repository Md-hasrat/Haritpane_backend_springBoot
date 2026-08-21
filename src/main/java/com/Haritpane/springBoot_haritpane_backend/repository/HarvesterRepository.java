package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.HarvesterService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvesterRepository extends JpaRepository<HarvesterService, Long> {
}
