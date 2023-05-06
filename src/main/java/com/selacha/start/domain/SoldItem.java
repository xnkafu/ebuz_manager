package com.selacha.start.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoldItem {
	// name model itemId sellingPrice itemPrice itemQty description
	private String name;
	private String mode;
	private Long itemId;
	private double sellingPrice;
	private double soldPrice;
	private int soldQty;
	private String itemDescription;
	
	
	
	

}
