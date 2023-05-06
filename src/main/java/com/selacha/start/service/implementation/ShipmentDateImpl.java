package com.selacha.start.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.ShipmentDate;
import com.selacha.start.repository.ShipmentDateRepo;
import com.selacha.start.service.ShipmentDateService;

@Service
public class ShipmentDateImpl implements ShipmentDateService {
	
	@Autowired
	private ShipmentDateRepo shipmentDateRepo;

	@Override
	public ShipmentDate save(ShipmentDate date) {
		Optional<ShipmentDate> tempDate = shipmentDateRepo.findByDate(date.getDate());
		if (tempDate.isEmpty()) {
			return shipmentDateRepo.save(date);
		}
		return null;
	}

	@Override
	public boolean deleteCategory(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShipmentDate findShipmentDate(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipmentDate> allShipmentDate() {
		return shipmentDateRepo.findAll();
	}

}
