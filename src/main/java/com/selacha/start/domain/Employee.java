package com.selacha.start.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@ManyToOne
	private Address address;
	
	@Column
	private String ssn;
	
	@Column
	private String dob;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private boolean isActive;
	
	@Column
	private Date employmentDate;

}

