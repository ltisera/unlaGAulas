package com.unla.unlaGAulas.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	@Column(name="edificio")
	private String edificio;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="edificio")
	private Set<Aula> aulas = new HashSet<Aula>();
	
}
