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
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrera;
	
	@Column(name="carrera")
	private String carrera;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idDepartamento", nullable=false)
	private Departamento departamento;
	
}
