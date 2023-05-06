package com.selacha.start.domain;


import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String salesDate;
	
	@Column
	private String confirmationCode;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Employee employee;
	
	@Column
	private String itemsSold;
	
	@Transient
	private ArrayList<SoldItem> itemsSoldAsList;
	
	@Column
	private double subTotal;
	
	@Column
	private double total;
	
	@Column
	private double tax;
	
	
}
