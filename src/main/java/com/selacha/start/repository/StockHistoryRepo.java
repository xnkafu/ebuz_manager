package com.selacha.start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.StockDate;
import com.selacha.start.domain.StockHistory;


public interface StockHistoryRepo extends JpaRepository<StockHistory,Long> {
	
	public List<StockHistory> findByStockDate(StockDate stockdate);
//	public Optional<Item> findByNameAndModel(String name,String model);

}
