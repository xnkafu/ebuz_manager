package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {
	
	public Optional<Category> findByName(String name);

}
