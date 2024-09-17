package com.mapping.Hibernate_One_To_Many_Unidirectional.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private long phone;
	
	public Trainee(String name, String address, long phone) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	


	
	
	
	
	
}
