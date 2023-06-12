package com.selacha.start.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.StoreTransaction;
import com.selacha.start.repository.TransactionRepo;
import com.selacha.start.service.TransactionService;

@Service
public class TransactionServiceImplementation implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
	

	@Override
	public Optional<StoreTransaction> findTransaction(long id) { 
		return transactionRepo.findById(id);
	}

	@Override
	public StoreTransaction saveTransaction(StoreTransaction transaction) {
		
		return transactionRepo.save(transaction);
	}

	@Override
	public double calculateTransactionByYear(int year) {
		List<StoreTransaction> transactions = transactionRepo.findStoreTransactionByYear(year);
		double transactionsByYear = 0.0;
		for (StoreTransaction storeTransaction: transactions) {
			if (storeTransaction.getType().equals("Store-expense")) {
				transactionsByYear -= storeTransaction.getAmount();
			} 
			else if (storeTransaction.getType().equals("Transfer-sent")) {
				transactionsByYear -= storeTransaction.getAmount();
			}
			else if (storeTransaction.getType().equals("Transfer-recieved")) {
				transactionsByYear += storeTransaction.getAmount();
			}
		}
		return transactionsByYear;
	}

	@Override
	public List<StoreTransaction> getAllTransaction() {
		return transactionRepo.findAll();
	}

	@Override
	public List<StoreTransaction> findTransactionByYear(int year) {
		return transactionRepo.findStoreTransactionByYear(year);
	}

}
