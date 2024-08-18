package com.adserver.adrotator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adserver.adrotator.dto.AdvertisementDTO;
import com.adserver.adrotator.service.AdvertisementService;
@RestController
@RequestMapping("/advs")
public class AdvertisementController {
    @Autowired
    private AdvertisementService adService;

    @PostMapping("/getAndUpdateWebSite")
    public List<AdvertisementDTO> updateViewsAndGetActiveAdvertisements() {
        return adService.getActiveAdvertisement();
    }

    @PostMapping("/addTimeAdv")
    public boolean addTimeAdv(@RequestPart("adv") String ta, @RequestPart("file") MultipartFile f) {
        return adService.addTimeAdvertisement(ta, f);
    }

    @PostMapping("/addViewAdv")
    public boolean addViewAdv(@RequestPart("adv") String ta, @RequestPart("file") MultipartFile f) {
        return adService.addViewAdvertisement(ta, f);
    }

}