package com.selacha.start.domain;

import java.sql.Date;

import jakarta.persistence.*;
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
	private Date dateAdded;
	
	@Column
	private Date dateSold;
	
	@Column
	private String soldBy;
	
	@Column
	private double soldFor;
	
	@Column
	private String comment;
	
	@ManyToOne
	private Item item;
	
	@Column
	private String barcode;
	
	@Transient
	private int quantity;
	

}
