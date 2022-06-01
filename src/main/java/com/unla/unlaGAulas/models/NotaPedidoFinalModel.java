package com.unla.unlaGAulas.models;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;
import com.unla.unlaGAulas.entities.Aula;
import com.unla.unlaGAulas.entities.Materia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class NotaPedidoFinalModel {
	
	private int idNotaPedidoFinal;
	
	private char turno;
	
	private Aula aula;
	
	@Min(3)
	private int cantEstudiantes;
	
	private Materia materia;
	
	private String observaciones;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaExamen;
	
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
		this.usuarioSolicitante = usuarioSolicitante;
	}
	
	
	
}
