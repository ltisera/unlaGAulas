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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class NotaPedidoFinal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNotaPedidoFinal;
	
	@Column(name="fecha")
	@CreationTimestamp
	private LocalDate fecha;
	
	@Column(name="turno")
	private char turno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idAula", nullable=false)
	private Aula aula;
	
	@Column(name="cantEstudiantes")
	private int cantEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idMateria", nullable=false)
	private Materia materia;
	
	@Column(name="observaciones")
	private String observaciones;
	
	@Column(name="fechaExamen")
	private LocalDate fechaExamen;
	
	@Column(name="estado")
	private boolean estado;
	
	@Column(name="usuarioSolicitante")
	private String usuarioSolicitante;

	public NotaPedidoFinal(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			LocalDate fechaExamen, String usuarioSolicitante) {
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.fechaExamen = fechaExamen;
		this.estado = false; //siempre que se crea no esta aceptado
		this.usuarioSolicitante = usuarioSolicitante;
	}

	
	
}
