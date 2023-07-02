package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.EmployeeReview;

public interface EmployeeReviewService {

	public EmployeeReview saveReview(EmployeeReview review);
	public EmployeeReview  findById(long id);
	public List<EmployeeReview> allReviews();
}
