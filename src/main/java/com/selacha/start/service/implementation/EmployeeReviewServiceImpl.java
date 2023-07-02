package com.selacha.start.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Employee;
import com.selacha.start.domain.EmployeeReview;
import com.selacha.start.repository.EmployeeRepo;
import com.selacha.start.repository.EmployeeReviewRepo;
import com.selacha.start.service.EmployeeReviewService;

@Service
public class EmployeeReviewServiceImpl implements EmployeeReviewService{
	
	@Autowired
	private EmployeeReviewRepo emplReviewRepo;

	@Autowired
	private EmployeeRepo emplRepo;
	
	@Override
	public EmployeeReview saveReview(EmployeeReview review) {
		Employee empl = emplRepo.findById(review.getEmployeeId()).get();
		review.setEmployee(empl);
		return emplReviewRepo.save(review);
	}

	@Override
	public EmployeeReview findById(long id) {
		
		return emplReviewRepo.findById(id).get();
	}

	@Override
	public List<EmployeeReview> allReviews() {
		// TODO Auto-generated method stub
		return emplReviewRepo.findAll();
	}

}
