package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ExcavationService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcavationRespository extends JpaRepository<ExcavationService, Long> {
}
