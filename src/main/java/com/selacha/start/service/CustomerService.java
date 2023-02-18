package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer cus);
	public List<Customer> getCustomers();

}
