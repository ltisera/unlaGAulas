package com.unla.unlaGAulas.service;

import java.time.LocalDate;
import java.util.List;

import com.unla.unlaGAulas.entities.Espacio;

public interface IEspacioService {
	
	public List<Espacio> getAll();
	
	public Espacio findExactDate(LocalDate fecha, char turno, int idAula);
	
	public Espacio insertOrUpdate(Espacio espacio);

}
