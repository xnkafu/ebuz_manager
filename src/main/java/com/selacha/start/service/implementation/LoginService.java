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
import com.selacha.start.repository.LoginRepo;
import com.selacha.start.service.CustomerService;
import com.selacha.start.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {
	
	
	
	@Autowired
	private LoginRepo loginRepo;

	
	public Employee login(Employee emp) {
		String username = emp.getUsername();
		Optional<Employee> employee = loginRepo.findByUsername(username);
		//Employee empTemp = employee.get();
		
		//log.info(empTemp.toString());
		if (!employee.isEmpty() && emp.getPassword().equals(employee.get().getPassword()) &&
				emp.getUsername().equals(employee.get().getUsername())) {
			employee.get().setPassword("XXXXXXXX");
			return employee.get();
		}
		return null;
	}


}
