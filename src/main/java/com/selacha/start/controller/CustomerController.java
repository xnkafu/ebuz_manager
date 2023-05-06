package com.selacha.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selacha.start.domain.Customer;
import com.selacha.start.service.implementation.CustomerServiceImpl;

@RestController
@RequestMapping("v1/api/customer")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	
	@PostMapping(value="/createCustomer", produces = "application/json")
	public  ResponseEntity<Customer> registerPerson(@RequestBody Customer  customer){
		Customer customerTemp = customerService.saveCustomer(customer);
		return customerTemp != null? new ResponseEntity<Customer>(customer, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/customers", produces = "application/json")
	public ResponseEntity<List<Customer>> getPersons(){
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{phoneNumber}", produces = "application/json")
	public ResponseEntity<Customer> getCustomerByPhone(@PathVariable("phoneNumber") String phone){
		return new ResponseEntity<Customer>(customerService.findByPhone(phone),HttpStatus.OK);
		
	}
	

}
