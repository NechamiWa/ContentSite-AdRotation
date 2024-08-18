package com.adserver.adrotator.dto;

import lombok.Data;

@Data
public class AreaDTO {

    private int code;
    private String name;
    private boolean free;
    private int pricePerMinute;
    private int pricePerView;

}
