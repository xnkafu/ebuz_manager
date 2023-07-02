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
import com.selacha.start.domain.EmployeeReview;
import com.selacha.start.domain.Note;
import com.selacha.start.service.EmployeeReviewService;
import com.selacha.start.service.implementation.CustomerServiceImpl;
import com.selacha.start.service.implementation.EmployeeServiceImpl;
import com.selacha.start.service.implementation.NoteServiceImpl;

@RestController
@RequestMapping("v1/api/employeeReview")
//@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@CrossOrigin(origins = {"https://cvs-sand.vercel.app/", "http://localhost:3000"}, allowedHeaders = "*", allowCredentials = "true")
public class EmployeeReviewController {
	
	@Autowired
	private EmployeeReviewService reviewService;
	
	
	@PostMapping(value="/createReview", produces = "application/json")
	public  ResponseEntity<EmployeeReview> registerReview(@RequestBody EmployeeReview  review){
		EmployeeReview reviewTemp = reviewService.saveReview(review);
		return reviewTemp != null? new ResponseEntity<EmployeeReview>(reviewTemp, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping(value="/reviews", produces = "application/json")
	public ResponseEntity<List<EmployeeReview>> getEmployees(){
		return new ResponseEntity<List<EmployeeReview>>(reviewService.allReviews(),HttpStatus.OK);
		
	}
	

}
