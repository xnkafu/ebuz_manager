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
import com.selacha.start.service.implementation.CategoryServiceImplementation;

@RestController
@RequestMapping("v1/api/category")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class CategoryController {

	@Autowired
	private CategoryServiceImplementation catService;

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Category> findById(@PathVariable  Long id) {

		Category category = catService.findCategory(id);

		return category != null? new ResponseEntity<Category>(category, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/createCategory", produces = "application/json")
	public  ResponseEntity<Category> registerPerson(@RequestBody Category  category){
		Category categoryTemp = catService.saveCategory(category);
		return categoryTemp != null? new ResponseEntity<Category>(category, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/categories", produces = "application/json")
	public ResponseEntity<List<Category>> getPersons(){
		return new ResponseEntity<List<Category>>(catService.allCategories(),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Boolean> createPerson(@PathVariable  Long id){
		boolean deleted = catService.deleteCategory(id);
		return deleted? new ResponseEntity<Boolean>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
