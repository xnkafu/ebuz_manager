package com.selacha.start.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Category;
import com.selacha.start.repository.CategoryRepo;
import com.selacha.start.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService{
	
	@Autowired
	private CategoryRepo catRepo;

	@Override
	public Category saveCategory(Category category) {
		Optional<Category> cat =  catRepo.findByName(category.getName());
		if (cat.isEmpty()) {
			return catRepo.save(category);
			
		}
		return null;
	}

	@Override
	public boolean deleteCategory(long id) {
		Optional<Category> cat =  catRepo.findById(id);
		if (!cat.isEmpty()) {
			catRepo.deleteById(id);
			return true;
			
		}
		return false;
	}

	@Override
	public Category findCategory(long id) {
		Optional<Category> cat =  catRepo.findById(id);
		if (!cat.isEmpty()) {
			return cat.get();
			
		}
		return null;
	}

	@Override
	public List<Category> allCategories() {
		return catRepo.findAll();
	}

}
