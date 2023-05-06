package com.selacha.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selacha.start.domain.Sales;

@Repository
public interface SalesRepo extends JpaRepository <Sales,Long>{

}
