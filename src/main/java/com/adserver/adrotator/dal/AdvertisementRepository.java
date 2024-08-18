package com.adserver.adrotator.dal;

import org.springframework.data.repository.CrudRepository;

import com.adserver.adrotator.model.Advertisement;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer>{

    
}
