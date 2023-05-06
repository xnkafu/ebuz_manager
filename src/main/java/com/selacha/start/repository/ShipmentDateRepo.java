package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Address;
import com.selacha.start.domain.ShipmentDate;



public interface ShipmentDateRepo extends JpaRepository<ShipmentDate,Long> {
	
	public Optional<ShipmentDate> findByDate(String date);

}
