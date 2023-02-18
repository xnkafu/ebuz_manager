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
import com.selacha.start.service.implementation.LoginService;

@RestController
@RequestMapping("v1/api")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping(value="/login", produces = "application/json")
	public  ResponseEntity<Employee> login(@RequestBody Employee  employee){
		Employee employeeTemp = loginService.login(employee);
		return employeeTemp != null? new ResponseEntity<Employee>(employeeTemp, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	

}
