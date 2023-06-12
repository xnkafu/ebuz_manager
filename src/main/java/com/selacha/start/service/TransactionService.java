package com.selacha.start.service;

import java.util.List;
import java.util.Optional;

import com.selacha.start.domain.StoreTransaction;



public interface TransactionService {
	
	public Optional<StoreTransaction> findTransaction(long id);
	public StoreTransaction saveTransaction(StoreTransaction transaction);
	public double calculateTransactionByYear(int year);
	public List<StoreTransaction> findTransactionByYear(int year);
	public List<StoreTransaction> getAllTransaction();
}
