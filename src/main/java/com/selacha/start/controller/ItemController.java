package com.selacha.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.selacha.start.domain.Item;
import com.selacha.start.service.implementation.ItemServiceImplementation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/api/item")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
@Slf4j
public class ItemController {

	@Autowired
	private ItemServiceImplementation itemService;

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Item> findById(@PathVariable  Long id) {

		Item item = itemService.findItem(id);

		return item != null? new ResponseEntity<Item>(item, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/createItem", produces = "application/json")
	public  ResponseEntity<Item> createItem(@RequestBody Item  item){
		log.info("item {}",item);
		Item itemTemp = itemService.saveItem(item);
		return itemTemp != null? new ResponseEntity<Item>(itemTemp, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/items", produces = "application/json")
	public ResponseEntity<List<Item>> getItem(){
		return new ResponseEntity<List<Item>>(itemService.allItems(),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Boolean> deleteItem(@PathVariable  Long id){
		boolean deleted = itemService.deleteItem(id);
		return deleted? new ResponseEntity<Boolean>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
}
