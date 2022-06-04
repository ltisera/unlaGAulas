package com.unla.unlaGAulas.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.unlaGAulas.entities.Espacio;
import com.unla.unlaGAulas.repositories.IEspacioRepository;
import com.unla.unlaGAulas.service.IEspacioService;

@Service("espacioService")
public class EspacioService implements IEspacioService{

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Override
	public List<Espacio> getAll() {
		return espacioRepository.findAll();
	}

	@Override
	public Espacio findExactDate(LocalDate fecha, char turno, int idAula) {
		return espacioRepository.findExactDate(fecha, turno, idAula);
	}

	@Override
	public Espacio insertOrUpdate(Espacio espacio) {
		return espacioRepository.save(espacio);
	}

}
