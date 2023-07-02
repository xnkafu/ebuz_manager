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
public class StockHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private StockDate stockDate;
	
	@ManyToOne
	private Item item;
	
//	@Column
//	private String item;
	
	@Column
	private String shipmentDate;
	
	@Column
	private int initialQty;
	
	@Column
	private int quantitySold;
	
	@Column
	private int expectedQty;
	
	@Column
	private int actualQty;
	
	@Transient
	private Employee user;

}

