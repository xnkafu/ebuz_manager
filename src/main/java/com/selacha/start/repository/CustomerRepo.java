package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Category;
import com.selacha.start.domain.Customer;

public interface CustomerRepo  extends JpaRepository<Customer,Long>{
	public Optional<Customer> findByPhone(String phone);

}
