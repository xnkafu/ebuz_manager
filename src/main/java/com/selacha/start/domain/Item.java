package com.selacha.start.domain;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String make;
	
	@Column
	private String model;
	
	@Column
	private int releaseYear;
	
	@Column
	private String description;
	
	@OneToOne
	private Category category;
	
	@Column
	private double purchasePrice;
	
	@Column
	private double sellingPrice;
	
	
	

}
