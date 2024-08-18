package com.adserver.adrotator.dto;

import lombok.Data;

@Data
public class ViewsAdvertisementDTO extends AdvertisementDTO {
	private int wantedViews;
	private int amountViews;

}
