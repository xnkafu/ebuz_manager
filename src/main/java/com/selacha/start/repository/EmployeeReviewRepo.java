package com.selacha.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.EmployeeReview;


public interface EmployeeReviewRepo extends JpaRepository<EmployeeReview,Long>{

}
