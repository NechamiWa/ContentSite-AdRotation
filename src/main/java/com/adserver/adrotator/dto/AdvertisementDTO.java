package com.adserver.adrotator.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertisementDTO {

    private int code;
    private int areaCode;
    private boolean active;
    private int customerCode;
    private Date orderDate;
    private byte[] file;
}
