package com.unla.unlaGAulas.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Espacio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspacio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="turno")
	private char turno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idAula", nullable=false)
	private Aula aula;
	
	@Column(name="libre")
	private boolean libre;
	
}
