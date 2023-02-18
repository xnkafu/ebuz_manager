package com.selacha.start.service;

import java.awt.image.BufferedImage;
import java.util.List;
import com.selacha.start.domain.Item;
import com.selacha.start.domain.ItemInventory;

public interface ItemInventoryService {

	public BufferedImage saveItemInventory(ItemInventory itemInventory);
	
	public boolean deleteItemInventory(long id);
	
	public ItemInventory findItemInventory(long id);
	
	public List<ItemInventory> allItemInventories();
}
