package com.selacha.start.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private Employee employee;
	
	@Column
	private Date date;
}
