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
import com.selacha.start.domain.StockDate;
import com.selacha.start.domain.StockHistory;
import com.selacha.start.repository.StockDateRepo;
import com.selacha.start.service.implementation.CategoryServiceImplementation;
import com.selacha.start.service.implementation.StockHistoryServiceImplementation;

@RestController
@RequestMapping("v1/api/stockHistory")
@CrossOrigin(origins = {"https://cvs-sand.vercel.app","http://localhost:3000"}, allowedHeaders = "*", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class StockHistoryController {

	@Autowired
	private StockHistoryServiceImplementation stockHistoryService;
	
	@Autowired
	private StockDateRepo stockDateRepo;

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<List<StockHistory>> findById(@PathVariable  Long id) {

		return  new ResponseEntity<List<StockHistory>>(stockHistoryService.findStockByStockDateId(id), HttpStatus.OK);
	}

	@PostMapping(value="/saveStockHistory", produces = "application/json")
	public  ResponseEntity<List<StockHistory>> saveStockHistory(@RequestBody List<StockHistory>  stockHistories){
		
		return new ResponseEntity<List<StockHistory>>(stockHistoryService.saveStockHistory(stockHistories), HttpStatus.OK);
	}
	
	@GetMapping(value="/stockDates", produces = "application/json")
	public ResponseEntity<List<StockDate>> getAllStockdates() {
		List<StockDate> dates = stockDateRepo.findAll();
		return  new ResponseEntity<List<StockDate>>(dates, HttpStatus.OK);
	}
	

}
