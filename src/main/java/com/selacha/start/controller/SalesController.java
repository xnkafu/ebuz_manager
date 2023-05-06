package com.selacha.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selacha.start.domain.Sales;
import com.selacha.start.service.SalesService;

@RestController
@RequestMapping("v1/api/sales")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	@GetMapping(value="", produces = "application/json")
	public ResponseEntity<List<Sales>> getAllSales(){
		return new ResponseEntity<List<Sales>>(salesService.getAllSales(),HttpStatus.OK);
		
	}
}
