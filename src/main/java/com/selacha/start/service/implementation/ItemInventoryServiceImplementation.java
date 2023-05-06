package com.selacha.start.service.implementation;


import java.awt.image.BufferedImage;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.selacha.start.domain.Item;
import com.selacha.start.domain.ItemInventory;
import com.selacha.start.domain.ItemStock;
import com.selacha.start.domain.Sales;
import com.selacha.start.domain.SalesObject;
import com.selacha.start.domain.ShipmentDate;
import com.selacha.start.domain.SoldItem;
import com.selacha.start.repository.EmployeeRepo;
import com.selacha.start.repository.ItemIventoryRepo;
import com.selacha.start.repository.ItemRepo;
import com.selacha.start.repository.SalesRepo;
import com.selacha.start.repository.ShipmentDateRepo;
import com.selacha.start.service.ItemInventoryService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemInventoryServiceImplementation implements ItemInventoryService {

	@Autowired
	private ItemIventoryRepo itemInventoryRepo;

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private ShipmentDateRepo sdRepo;
	
	@Autowired
	private SalesRepo salesRepo;

	@Override
	public BufferedImage saveItemInventory(ItemInventory itemInventory) {

		//Optional<ItemInventory> itemTemp =  itemInventoryRepo.findByShipmentDate(itemInventory.getShipmentDate());
	//	if (itemTemp.isEmpty()) {
			ItemInventory itemTemp2 = itemInventoryRepo.save(itemInventory);
			String barcodeString = itemTemp2.getId()+";"+itemTemp2.getItem().getId();
			itemTemp2.setBarcode(barcodeString);
			itemInventoryRepo.save(itemInventory);
			return this.generateBarcode(itemTemp2);
		

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

	public List<ItemStock> showStock(){
		List<ShipmentDate> shipmentDates = sdRepo.findAll();
		List<Item> items = itemRepo.findAll();

		List<ItemStock> stock = new ArrayList<>();
		for (Item itm: items) {
			for (ShipmentDate shipmentDate: shipmentDates ) {
				List<ItemInventory> stockTemp = itemInventoryRepo.findByShipmentDateAndItemId(shipmentDate.getDate(), itm.getId());
				int count = stockTemp.size();
				int sold = 0;
				if (count != 0) {
					for (ItemInventory iv: stockTemp) {
						if (iv.isSold() == true) {
							sold++;
						}
					}

					ItemStock s = new ItemStock();
					s.setShipmentDate(shipmentDate.getDate());
					s.setQuantitySold(sold);
					s.setInitialStock(count);
					s.setCurrentStock(count - sold);
					s.setItem(itm);
					stock.add(s);
					sold =0;
				}
			}
		}



		return stock;
	}
	
	@Transactional
	public Sales performSaleNoScanner(SalesObject salesObject) {
		Sales sales = new Sales();
		String itemsSold = "";
		List<ItemStock> cart = salesObject.getCart();
		
		log.info(salesObject.toString());
		String confirmationCode = generateConfirmationCode();
		sales.setConfirmationCode(confirmationCode);
		log.info(confirmationCode);
		for (ItemStock itmStock: cart) {
			//log.info("itmQty", itmStock.getCartItemQty());
			log.info(itmStock.getCartItemQty() + "");
			log.info(itemInventoryRepo.findBySoldAndItemIdAndShipmentDate(false, itmStock.getItem().getId(), itmStock.getShipmentDate()).toString());
			log.info("here");
			log.info(itmStock.getItem().toString());
			List<ItemInventory> list = itemInventoryRepo.findBySoldAndItemIdAndShipmentDate(false, itmStock.getItem().getId(),itmStock.getShipmentDate()).subList(0, itmStock.getCartItemQty());
			log.info(list.toString());
			for(ItemInventory inventory: list) {
				inventory.setSold(true);
				inventory.setSoldFor(itmStock.getCartItemPrice());
				log.info("empl");
				log.info(salesObject.getEmployee().toString());
				inventory.setSoldBy(salesObject.getEmployee());
				inventory.setDateSold(LocalDate.now());
				inventory.setCustomer(salesObject.getCustomer());
				inventory.setConfirmationCode(confirmationCode);
				inventory.setTimeStamp(LocalTime.now().toString());
				
				itemInventoryRepo.save(inventory);
				
			}
			// name model itemId sellingPrice soldPrice itemQty description
			itemsSold += itmStock.getItem().getName() + ":" + itmStock.getItem().getModel() + ":" +
					itmStock.getItem().getId() + ":" + itmStock.getItem().getSellingPrice() + ":" +
					itmStock.getCartItemPrice() + ":" + itmStock.getCartItemQty() + ":" +
					itmStock.getItem().getDescription() + ":end" + ",";
		}
		sales.setItemsSold(itemsSold);
		sales.setCustomer(salesObject.getCustomer());
		sales.setEmployee(salesObject.getEmployee());
		sales.setSalesDate(salesObject.getSalesDate());
		sales.setTotal(salesObject.getTotal());
		
		Sales savedSale = salesRepo.save(sales);
		
		savedSale.setItemsSoldAsList(decodeSoldItems(itemsSold));
		
		return savedSale;
	}
	
	// name model itemId sellingPrice soldPrice itemQty description
	public ArrayList<SoldItem> decodeSoldItems( String soldItems) {
		log.info("****sold Items" + soldItems);
		
		ArrayList<SoldItem> soldItemsDecoded = new ArrayList<>();
		String[] itemsUndecoded = soldItems.split(",");
		for(String itemUndecoded: itemsUndecoded) {
			String[] itemAsArray = itemUndecoded.split(":");
			log.info(itemAsArray.length + "");
			SoldItem si = SoldItem.builder()
					.name(itemAsArray[0])
					.mode(itemAsArray[1])
					.itemId(Long.parseLong(itemAsArray[2]))
					.sellingPrice(Double.parseDouble(itemAsArray[3]))
					.soldPrice(Double.parseDouble(itemAsArray[4]))
					.soldQty(Integer.parseInt(itemAsArray[5]))
					.itemDescription(itemAsArray[6])
					.build();
			soldItemsDecoded.add(si);
		}
		
		return soldItemsDecoded;
	}
	
	public String generateConfirmationCode() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();

	    return generatedString;
	}

}
