package com.selacha.start.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class EmployeeReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private Employee employee;
	
	@Transient
	private long employeeId;
	
	@ManyToOne
	private Employee reporter;
	
	@Column
	private Date date;
	
	@Column
	private String reviewType;
}
