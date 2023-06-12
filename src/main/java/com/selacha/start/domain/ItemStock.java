package com.selacha.start.domain;

import lombok.Data;

@Data
public class ItemStock {
	
	private Item item;
	
	private int currentStock;
	
	private int quantitySold;
	
	private int initialStock;
	
	private int expectedStock;
	
	private String shipmentDate;
	
	private int cartItemQty;
	
	private double cartItemPrice;

}
