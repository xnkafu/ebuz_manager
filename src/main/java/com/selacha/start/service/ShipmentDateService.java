package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Category;
import com.selacha.start.domain.ShipmentDate;

public interface ShipmentDateService {
	
	public ShipmentDate save(ShipmentDate date);
	
	public boolean deleteCategory(long id);
	
	public ShipmentDate findShipmentDate(long id);
	
	public List<ShipmentDate> allShipmentDate();

}
