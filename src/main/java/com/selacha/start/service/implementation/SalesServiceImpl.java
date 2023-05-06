package com.selacha.start.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Sales;
import com.selacha.start.repository.SalesRepo;
import com.selacha.start.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService{

	@Autowired
	private SalesRepo salesRepo;
	
	@Override
	public Sales saveSale(Sales sale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sales> getAllSales() {
		return salesRepo.findAll();
	}

}
