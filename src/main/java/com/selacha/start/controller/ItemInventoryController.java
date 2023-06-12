package com.selacha.start.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.selacha.start.domain.ItemInventory;
import com.selacha.start.domain.ItemStock;
import com.selacha.start.domain.Sales;
import com.selacha.start.domain.SalesObject;
import com.selacha.start.service.implementation.ItemInventoryServiceImplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1/api/itemInventory")
//@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@CrossOrigin(origins = {"https://cvs-sand.vercel.app/","http://localhost:3000"}, allowedHeaders = "*", allowCredentials = "true")
public class ItemInventoryController {

	@Autowired
	private ItemInventoryServiceImplementation itemInventoryService;

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<ItemInventory> findById(@PathVariable  Long id) {

		ItemInventory itemInventory = itemInventoryService.findItemInventory(id);

		return itemInventory != null? new ResponseEntity<ItemInventory>(itemInventory, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/createItemInventory", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
	public  ResponseEntity<BufferedImage> create(@RequestBody ItemInventory  itemInventory){
		BufferedImage image = itemInventoryService.saveItemInventory(itemInventory);
		return  new ResponseEntity<>(image, HttpStatus.OK);

	}
	
	@GetMapping(value="/itemInventories", produces = "application/json")
	public ResponseEntity<List<ItemInventory>> getItem(){
		return new ResponseEntity<List<ItemInventory>>(itemInventoryService.allItemInventories(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/stock", produces = "application/json")
	public ResponseEntity<List<ItemStock>> getStock(){
		return new ResponseEntity<List<ItemStock>>(itemInventoryService.showStock(),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Boolean> deleteItem(@PathVariable  Long id){
		boolean deleted = itemInventoryService.deleteItemInventory(id);
		return deleted? new ResponseEntity<Boolean>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping(value="/performSaleNS",produces = "application/json")
	public  ResponseEntity<Sales> saveSaleNoScanner(@RequestBody SalesObject salesObject){
		Sales sale = itemInventoryService.performSaleNoScanner(salesObject);
		log.info(sale.toString());
		return new ResponseEntity<Sales>( sale,HttpStatus.OK);
	}
}
