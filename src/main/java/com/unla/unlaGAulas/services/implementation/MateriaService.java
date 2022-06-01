package com.unla.unlaGAulas.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.unlaGAulas.entities.Materia;
import com.unla.unlaGAulas.repositories.IMateriaRepository;
import com.unla.unlaGAulas.service.IMateriaService;

@Service("materiaService")
public class MateriaService implements IMateriaService {
	
	@Autowired
	@Qualifier("materiaRepository")
	private IMateriaRepository materiaRepository;
	
	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

}
