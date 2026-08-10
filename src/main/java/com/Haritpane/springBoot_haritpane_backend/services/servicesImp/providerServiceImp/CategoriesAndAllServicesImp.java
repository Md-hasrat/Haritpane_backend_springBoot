package com.Haritpane.springBoot_haritpane_backend.services.servicesImp.providerServiceImp;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceCategoryRepository;
import com.Haritpane.springBoot_haritpane_backend.services.providerService.CateogoriesAndAllServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesAndAllServicesImp implements CateogoriesAndAllServices {

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;


    @Override
    public List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) {
            return serviceCategoryRepository.findAll();
        }

        return serviceCategoryRepository.findByName(categoryName);
    }
}
