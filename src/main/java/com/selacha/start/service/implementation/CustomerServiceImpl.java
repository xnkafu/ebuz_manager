package com.selacha.start.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Address;
import com.selacha.start.domain.Customer;
import com.selacha.start.repository.AddressRepo;
import com.selacha.start.repository.CustomerRepo;
import com.selacha.start.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer saveCustomer(Customer cus) {
		log.info(cus.toString());
		Address add = addressRepo.save(cus.getAddress());
		Optional<Customer> tempCus = customerRepo.findByPhone(cus.getPhone());
		Customer customer = null;
		if (add != null && tempCus.isEmpty()) {
			customer = customerRepo.save(cus);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

}
