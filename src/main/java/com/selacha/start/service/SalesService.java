package com.selacha.start.service;


import java.util.List;

import com.selacha.start.domain.Sales;

public interface SalesService {

	public Sales saveSale(Sales sale);
	
	public List<Sales> getAllSales();
	
}
