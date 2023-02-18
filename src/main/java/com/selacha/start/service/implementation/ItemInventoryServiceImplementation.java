package com.selacha.start.service.implementation;


import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.selacha.start.domain.ItemInventory;
import com.selacha.start.repository.ItemIventoryRepo;
import com.selacha.start.service.ItemInventoryService;

@Service
public class ItemInventoryServiceImplementation implements ItemInventoryService {
	
	@Autowired
	private ItemIventoryRepo itemInventoryRepo;

	@Override
	public BufferedImage saveItemInventory(ItemInventory itemInventory) {
		
		
		//	Optional<ItemInventory> itemTemp =  itemInventoryRepo.findBySerialNum(itemInventory.getSerialNum());
		//	if (itemTemp.isEmpty()) {
				ItemInventory itemTemp2 = itemInventoryRepo.save(itemInventory);
				itemTemp2.setBarcode(itemTemp2.getId()+";"+itemTemp2.getItem().getId());
				return this.generateBarcode(itemTemp2);
				
				
			//}
		
	}

	@Override
	public boolean deleteItemInventory(long id) {
		Optional<ItemInventory> itemInventory =  itemInventoryRepo.findById(id);
		if (!itemInventory.isEmpty()) {
			itemInventoryRepo.deleteById(id);
			return true;
			
		}
		return false;
	}

	@Override
	public ItemInventory findItemInventory(long id) {
		Optional<ItemInventory> itemInventory =  itemInventoryRepo.findById(id);
		if (!itemInventory.isEmpty()) {
			return itemInventory.get();
			
		}
		return null;
	}

	@Override
	public List<ItemInventory> allItemInventories() {
		return itemInventoryRepo.findAll();
	}

	
	public BufferedImage generateBarcode(ItemInventory itemTemp) {
		Code128Writer writer = new Code128Writer();
		BufferedImage barcodeImage = null;
		try {
			BitMatrix matrix = writer.encode(itemTemp.getBarcode(), BarcodeFormat.CODE_128, 100, 50);
			barcodeImage = MatrixToImageWriter.toBufferedImage(matrix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return barcodeImage;
	}
	
}
