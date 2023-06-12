package com.selacha.start.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class StoreTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String type;
	
	@Column
	private String description;
	
	@ManyToOne
	private Employee employee;
	
	@Column
	private Date date;
	
	@Column
	private int year;
	
	@Column
	private double amount;
	
	@Transient
	private final String[] types = {"Transfer-sent", "Transfer-recieved", "Store-expense"};
}
