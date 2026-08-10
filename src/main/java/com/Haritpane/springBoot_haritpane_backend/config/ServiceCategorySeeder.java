package com.Haritpane.springBoot_haritpane_backend.config;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceCategorySeeder {

    @Bean
    CommandLineRunner seedServiceCategory(
            ServiceCategoryRepository categoryRepository
            ){

        return args -> {

            List<String> categories = List.of(
                    "Land Management Services",
                    "Harvester",
                    "Cattle Purchase & Sale",
                    "Excavation",
                    "Electrostatic Spraying",
                    "Labor Requirement",
                    "Transportation",
                    "Borewell Construction",
                    "Cow Dunk Supply",
                    "Compound Wall Builder",
                    "Drone Services",
                    "Auger Services"
            );

            for (String categoryName : categories) {

                if (!categoryRepository.existsByName(categoryName)) {

                    ServiceCategoryEntity category =
                            new ServiceCategoryEntity();

                    category.setName(categoryName);

                    categoryRepository.save(category);
                }
            }
        };
    }
}
