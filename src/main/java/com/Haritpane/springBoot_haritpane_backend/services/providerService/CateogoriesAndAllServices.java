package com.Haritpane.springBoot_haritpane_backend.services.providerService;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceCategoryEntity;

import java.util.List;

public interface CateogoriesAndAllServices {

    List<ServiceCategoryEntity> getServicesByCategoryName(String categoryName);
}
