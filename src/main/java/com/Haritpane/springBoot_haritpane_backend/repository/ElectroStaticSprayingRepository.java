package com.Haritpane.springBoot_haritpane_backend.repository;


import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.serviceName.ElectroStaticSpraying;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectroStaticSprayingRepository
        extends JpaRepository<ElectroStaticSpraying, Long> {
}