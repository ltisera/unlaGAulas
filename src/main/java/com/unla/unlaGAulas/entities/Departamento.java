package com.unla.unlaGAulas.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	
	@Column(name="departamento")
	private String departamento;
	
}
