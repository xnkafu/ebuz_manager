package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Item;


public interface ItemRepo extends JpaRepository<Item,Long> {
	
	public Optional<Item> findByname(String name);

}
