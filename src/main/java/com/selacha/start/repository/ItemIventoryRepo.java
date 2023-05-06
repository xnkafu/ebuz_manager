package com.selacha.start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.selacha.start.domain.Item;
import com.selacha.start.domain.ItemInventory;


public interface ItemIventoryRepo extends JpaRepository<ItemInventory,Long> {
	
	public Optional<ItemInventory> findBySerialNum(String name);
	public List<ItemInventory> findByShipmentDateAndItemId(String date,long itemId);
	public List<ItemInventory> findBySoldAndItemIdAndShipmentDate(boolean sold, Long itmId, String shipmentDate);
	public List<ItemInventory> findByItemId(Long itmId);
	
	//@Query(value="Select * from public.item_inventory r where r.sold=?1 and r.item.id=?2", nativeQuery=true)
	//public List<ItemInventory> queryInventory(boolean isSold, long itm);
	

}
