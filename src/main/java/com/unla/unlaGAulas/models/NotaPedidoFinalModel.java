package com.unla.unlaGAulas.models;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import com.unla.unlaGAulas.entities.Aula;
import com.unla.unlaGAulas.entities.Materia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class NotaPedidoFinalModel {
	
	private int idNotaPedidoFinal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private char turno;
	
	private Aula aula;
	
	private int cantEstudiantes;
	
	private Materia materia;
	
	private String observaciones;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaExamen;
	
	private boolean estado;
	
	private String usuarioSolicitante;

	public NotaPedidoFinalModel(int idNotaPedidoFinal, char turno, Aula aula, int cantEstudiantes,
			Materia materia, String observaciones, LocalDate fechaExamen, String usuarioSolicitante) {
		this.setIdNotaPedidoFinal(idNotaPedidoFinal);
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.fechaExamen = fechaExamen;
		this.estado = false;
		this.usuarioSolicitante = usuarioSolicitante;
	}
	
	public NotaPedidoFinalModel(int idNotaPedidoFinal, LocalDate fecha, char turno, Aula aula, int cantEstudiantes,
			Materia materia, String observaciones, LocalDate fechaExamen, String usuarioSolicitante) {
		this.setIdNotaPedidoFinal(idNotaPedidoFinal);
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.fechaExamen = fechaExamen;
		this.estado = false;
		this.usuarioSolicitante = usuarioSolicitante;
	}
	
}
