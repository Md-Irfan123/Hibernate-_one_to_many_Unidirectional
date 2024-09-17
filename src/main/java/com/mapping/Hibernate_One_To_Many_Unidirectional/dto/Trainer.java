package com.mapping.Hibernate_One_To_Many_Unidirectional.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trainer {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Trainee> trainees;

}
