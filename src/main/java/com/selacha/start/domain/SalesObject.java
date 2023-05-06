package com.selacha.start.domain;

import java.util.List;

import lombok.Data;

@Data
public class SalesObject {
	
	private List<ItemStock> cart;
	
	private Customer customer;
	
	private Employee employee;
	
	private String salesDate;
	
	private double total;

}
