package com.unla.unlaGAulas.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


import org.springframework.format.annotation.DateTimeFormat;

import com.unla.unlaGAulas.entities.Aula;
import com.unla.unlaGAulas.entities.Materia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class NotaPedidoCursoModel {
	
	private int idNotaPedidoCurso;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	private char turno;

	private Aula aula;

	private int cantEstudiantes;

	private Materia materia;

	private String observaciones;
	
	private String codCurso;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Set<LocalDate> fechasCursada = new HashSet<LocalDate>();
	
	private boolean estado;
	
	private int porcentajeCursada;

	private String usuarioSolicitante;

	public NotaPedidoCursoModel(int idNotaPedidoCurso, char turno, Aula aula, int cantEstudiantes,
			Materia materia, String observaciones, String codCurso, Set<LocalDate> fechasCursada, int porcentajeCursada,
			String usuarioSolicitante) {
		this.setIdNotaPedidoCurso(idNotaPedidoCurso);
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.codCurso = codCurso;
		this.fechasCursada = fechasCursada;
		this.estado = false;
		this.porcentajeCursada = porcentajeCursada;
		this.usuarioSolicitante = usuarioSolicitante;
	}
	
	public NotaPedidoCursoModel(int idNotaPedidoCurso, LocalDate fecha, char turno, Aula aula, int cantEstudiantes,
			Materia materia, String observaciones, String codCurso, Set<LocalDate> fechasCursada, int porcentajeCursada,
			String usuarioSolicitante) {
		this.setIdNotaPedidoCurso(idNotaPedidoCurso);
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.codCurso = codCurso;
		this.fechasCursada = fechasCursada;
		this.estado = false;
		this.porcentajeCursada = porcentajeCursada;
		this.usuarioSolicitante = usuarioSolicitante;
	}

}
