package com.selacha.start.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Address;
import com.selacha.start.domain.Customer;
import com.selacha.start.domain.Employee;
import com.selacha.start.repository.AddressRepo;
import com.selacha.start.repository.CustomerRepo;
import com.selacha.start.repository.EmployeeRepo;
import com.selacha.start.service.CustomerService;
import com.selacha.start.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private EmployeeRepo emplRepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		log.info(emp.toString());
		Address add = addressRepo.save(emp.getAddress());
		Optional<Employee> tempEmpl = emplRepo.findByPhone(emp.getPhone());
		Optional<Employee> tempEmpl2 = emplRepo.findBySsn(emp.getSsn());
		Employee employee = null;
		if (add != null && tempEmpl.isEmpty() && tempEmpl2.isEmpty()) {
			emp.setActive(true);
			emp.setEmploymentDate(new Date());
			emp.setAddress(add);
			employee = emplRepo.save(emp);
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		return emplRepo.findAll();
	}

}
