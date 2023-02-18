package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Item;
import com.selacha.start.domain.ItemInventory;


public interface ItemIventoryRepo extends JpaRepository<ItemInventory,Long> {
	
	public Optional<ItemInventory> findBySerialNum(String name);

}
