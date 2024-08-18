package com.adserver.adrotator.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.adserver.adrotator.dto.AdvertisementDTO;
import com.adserver.adrotator.model.TimeAdvertisement;

public interface AdvertisementService {
    public List<AdvertisementDTO> getActiveAdvertisement();
    public boolean addTimeAdvertisement(String ta, MultipartFile file);
    public void saveFile(MultipartFile file, String code);
    public void scheduleDeactivation(TimeAdvertisement ad);
    public boolean addViewAdvertisement(String ta, MultipartFile file);

} 
