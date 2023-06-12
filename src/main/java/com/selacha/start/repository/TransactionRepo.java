package com.selacha.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.StoreTransaction;

public interface TransactionRepo extends JpaRepository<StoreTransaction,Long>{
	
	public List<StoreTransaction> findStoreTransactionByYear(int year);

}
