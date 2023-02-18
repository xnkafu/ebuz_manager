package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Category;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	
	public boolean deleteCategory(long id);
	
	public Category findCategory(long id);
	
	public List<Category> allCategories();

}
