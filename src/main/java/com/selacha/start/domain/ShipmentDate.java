package com.selacha.start.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ShipmentDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String date;
	
	@ManyToOne
	private Employee employee;
	
}
