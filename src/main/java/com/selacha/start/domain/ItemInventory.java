package com.selacha.start.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ItemInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private boolean sold;
	
	@Column
	private String serialNum;
	
	@Column
	private LocalDate dateAdded;
	
	@Column
	private Date dateSold;
	
	//@Column
	@ManyToOne
	private Employee soldBy;
	
	@Column
	private double soldFor;
	
	@Column
	private String comment;
	
	@ManyToOne
	private Item item;
	
	@Column
	private String barcode;
	
	//@Transient
	//private int quantity;
	
	@Column
	private String shipmentDate;
	
	@Column
	private String confirmationCode;
	
	@ManyToOne
	private Customer customer;
	
	@Column
	private String timeStamp;
	

}
