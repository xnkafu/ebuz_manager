package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public List<Employee> getEmployees();

}
