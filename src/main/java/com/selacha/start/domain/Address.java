package com.selacha.start.domain;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String street;
	
	@Column
	private String suite;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zip;

}
