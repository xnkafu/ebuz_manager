package com.selacha.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Employee;


public interface EmployeeRepo  extends JpaRepository<Employee,Long>{
	public Optional<Employee> findByPhone(String phone);
	public Optional<Employee> findBySsn(String ssn);

}
