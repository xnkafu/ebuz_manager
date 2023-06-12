package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer cus) throws Exception;
	public List<Customer> getCustomers();

}
