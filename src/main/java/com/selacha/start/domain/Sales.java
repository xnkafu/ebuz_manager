package com.selacha.start.domain;



import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

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
	private Date salesDate;
	
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
