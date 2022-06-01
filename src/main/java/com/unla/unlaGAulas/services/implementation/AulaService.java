package com.unla.unlaGAulas.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.unlaGAulas.entities.Aula;
import com.unla.unlaGAulas.repositories.IAulaRepository;
import com.unla.unlaGAulas.service.IAulaService;

@Service("aulaService")
public class AulaService implements IAulaService{
	
	@Autowired
	@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;

	@Override
	public List<Aula> getAll() {
		return aulaRepository.findAll();
	}

}
