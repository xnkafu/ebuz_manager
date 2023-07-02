package com.selacha.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Note;
import com.selacha.start.domain.StockDate;

public interface StockDateRepo extends JpaRepository<StockDate,Long>{

}
