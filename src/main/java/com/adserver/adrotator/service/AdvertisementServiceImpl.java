package com.adserver.adrotator.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.adserver.adrotator.model.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.adserver.adrotator.dal.AdvertisementRepository;
import com.adserver.adrotator.dal.AreaRepsitory;
import com.adserver.adrotator.dto.AdvertisementDTO;
import com.adserver.adrotator.dto.TimeAdvertisementDTO;
import com.adserver.adrotator.dto.ViewsAdvertisementDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advRep;
    @Autowired
    private AreaRepsitory areaRep;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ObjectMapper objMapper;

    @Override
    public List<AdvertisementDTO> getActiveAdvertisement() {

        List<AdvertisementDTO> activeAdvertisements = ((List<Advertisement>) advRep.findAll()).stream()
                .filter(ad -> ad.isActive())
                // .limit(4)
                .map(ad -> {
                    if (ad instanceof ViewsAdvertisement) {
                        ViewsAdvertisement vad = (ViewsAdvertisement) ad;
                        synchronized (vad) {
                            vad.setAmountViews(vad.getAmountViews() + 1);
                            if (vad.getAmountViews() >= vad.getWantedViews()) {
                                vad.setActive(false);
                                advRep.save(vad);
                                vad.getArea_().setFree(true);
                                areaRep.save(vad.getArea_());
                            }
                        }
                    }
                    AdvertisementDTO dto = mapper.map(ad, AdvertisementDTO.class);
                    try (InputStream in = new FileInputStream("C:\\myFolder\\pic" + dto.getCode() + ".png")) {
                        dto.setFile(StreamUtils.copyToByteArray(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return dto;
                })
                .toList();

        return activeAdvertisements;
    }

    @Override
    public boolean addTimeAdvertisement(String ta, MultipartFile file) {
        try {
            TimeAdvertisementDTO ad = objMapper.readValue(ta, TimeAdvertisementDTO.class);
            Area area = areaRep.findById(ad.getAreaCode()).get();
            if (area == null) {
                throw new IllegalArgumentException("Area not found");
            }

            synchronized (area) {
                if (area.isFree()) {
                    ad.setActive(true);
                    ad.setOrderDate(new Date());
                     Advertisement a1=advRep.save(mapper.map(ad,TimeAdvertisement.class)); //TO ASK

                    area.setFree(false);
                    areaRep.save(area);

                    saveFile(file, String.valueOf(a1.getCode()));
                    ad.setCode(a1.getCode());
                    TimeAdvertisement tad = mapper.map(ad, TimeAdvertisement.class);
                    scheduleDeactivation(tad);
                    return true;
                } else {
                    return false;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing advertisement data", e);
        } catch (IllegalStateException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    @Override
    public void saveFile(MultipartFile file, String code) {
        try {
            File serverFile = new File("C:\\myFolder\\pic" + code + ".png");
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving advertisement file", e);
        }

    }

    @Override
    public void scheduleDeactivation(TimeAdvertisement ad) {
        long delay = ad.getMinutes() * 60 * 1000L;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ad.setActive(false);
                Area area = ad.getArea_();
                area.setFree(true);
                advRep.save(ad);
                areaRep.save(area);
            }
        }, delay);
    }

    @Override
    public boolean addViewAdvertisement(String ta, MultipartFile file) {

        try {
            ViewsAdvertisementDTO ad = objMapper.readValue(ta, ViewsAdvertisementDTO.class);
            Area area = areaRep.findById(ad.getAreaCode()).get();
            if (area == null) {
                throw new IllegalArgumentException("Area not found");
            }

            synchronized (area) {
                if (area.isFree()) {
                    ad.setActive(true);
                    ad.setOrderDate(new Date());
                    // advRep.save(ad); //TO ASK

                    area.setFree(false);
                    areaRep.save(area);

                    saveFile(file, String.valueOf(ad.getCode()));
                    return true;
                } else {
                    throw new IllegalStateException("Area is not available");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing advertisement data", e);
        } catch (IllegalStateException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
