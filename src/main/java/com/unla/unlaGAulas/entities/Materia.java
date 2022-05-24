package com.unla.unlaGAulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMateria;
	
	@Column(name="codMateria")
	private int codMateria;
	
	@Column(name="materia")
	private String materia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCarrera", nullable=false)
	private Carrera carrera;
	
}
