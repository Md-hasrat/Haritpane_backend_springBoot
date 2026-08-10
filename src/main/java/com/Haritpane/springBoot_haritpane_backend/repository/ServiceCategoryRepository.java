package com.Haritpane.springBoot_haritpane_backend.repository;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategoryEntity, Long> {

    boolean existsByName(String name);
    List<ServiceCategoryEntity> findByName(String name);

}
