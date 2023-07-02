package com.selacha.start.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class StockDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date date;
	
	@ManyToOne
	private Employee employee;
	
}
