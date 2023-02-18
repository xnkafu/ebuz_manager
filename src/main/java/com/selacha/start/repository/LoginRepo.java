package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Employee;


public interface LoginRepo  extends JpaRepository<Employee,Long>{
	public Optional<Employee> findByUsername(String username);

}
