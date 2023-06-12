package com.selacha.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selacha.start.domain.Customer;
import com.selacha.start.domain.Employee;
import com.selacha.start.service.implementation.CustomerServiceImpl;
import com.selacha.start.service.implementation.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/api/employee")
@Slf4j
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = {"https://cvs-sand.vercel.app","http://localhost:3000"}, allowedHeaders = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	@PostMapping(value="/createEmployee", produces = "application/json")
	public  ResponseEntity<Employee> registerEmployee(@RequestBody Employee  employee){
		log.info("About to save employee.");
		log.info(employee.toString());
		Employee employeeTemp = employeeService.saveEmployee(employee);
		return employeeTemp != null? new ResponseEntity<Employee>(employee, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(),HttpStatus.OK);
		
	}
	

}
