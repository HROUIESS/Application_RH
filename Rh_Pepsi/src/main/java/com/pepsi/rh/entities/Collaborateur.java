/**
 * 
 */
package com.pepsi.rh.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


import lombok.Data;


@Component
@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="collaborateur_type")

public class Collaborateur {

	@Id
	@GeneratedValue
	long id;
	@Column(unique = true,length=10)
	String cin;
	@Column(length=20)
	String nom, prenom, tel;
	@Column(length=60)
	String adresse,email;
	@Column(length=11)@Enumerated(EnumType.STRING)
	Situation situation;
	@Column(length=6)@Enumerated(EnumType.STRING)
	Gender sexe;
	LocalDate date_borth, date_recrut;
	@Column(length=10)
	String ncnss;
	
	@OneToMany(mappedBy = "collaborateur")
	List<Absences> absences=new ArrayList<>();
	
	
	
	
	

}
