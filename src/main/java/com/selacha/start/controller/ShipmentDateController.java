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
import com.selacha.start.domain.Category;
import com.selacha.start.domain.ShipmentDate;
import com.selacha.start.service.implementation.CategoryServiceImplementation;
import com.selacha.start.service.implementation.ShipmentDateImpl;

@RestController
@RequestMapping("v1/api/shipmentDate")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class ShipmentDateController {

	@Autowired
	private ShipmentDateImpl shipmentDateService;

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Category> findById(@PathVariable  Long id) {

		return null;
		//Category category = catService.findCategory(id);

		//return category != null? new ResponseEntity<Category>(category, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/createShipmentDate", produces = "application/json")
	public  ResponseEntity<ShipmentDate> registerDate(@RequestBody ShipmentDate  date){
		ShipmentDate shipmentDateTemp = shipmentDateService.save(date);
		return shipmentDateTemp != null? new ResponseEntity<ShipmentDate>(shipmentDateTemp, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/shipmentDates", produces = "application/json")
	public ResponseEntity<List<ShipmentDate>> getAllDates(){
		return new ResponseEntity<List<ShipmentDate>>(shipmentDateService.allShipmentDate(),HttpStatus.OK);
		
	}
	
	

}
