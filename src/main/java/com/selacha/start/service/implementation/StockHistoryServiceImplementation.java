package com.selacha.start.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.StockDate;
import com.selacha.start.domain.StockHistory;
import com.selacha.start.repository.StockDateRepo;
import com.selacha.start.repository.StockHistoryRepo;

@Service
public class StockHistoryServiceImplementation {
	
	@Autowired
	private StockHistoryRepo stockHistoryRepo;
	
	@Autowired
	private StockDateRepo stockDateRepo;
	
	public List<StockHistory> saveStockHistory(List<StockHistory> histories) {
		Date date = new Date();
		
		StockDate sd = new StockDate();
		sd.setDate(date);
		
		StockDate savedStockDate = stockDateRepo.save(sd);
		
		for (StockHistory history: histories) {
			history.setStockDate(savedStockDate);
		}
		
		return stockHistoryRepo.saveAll(histories);
	}
	
	public List<StockHistory> findStockByStockDateId(long  id) {
		StockDate stockDate = stockDateRepo.findById(id).get();
		return stockHistoryRepo.findByStockDate(stockDate);	
	}

}
