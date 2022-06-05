package com.unla.unlaGAulas.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.unlaGAulas.entities.NotaPedidoCurso;
import com.unla.unlaGAulas.models.NotaPedidoCursoModel;
import com.unla.unlaGAulas.repositories.INotaPedidoCursoRepository;
import com.unla.unlaGAulas.service.INotaPedidoCursoService;

@Service("notaPedidoCursoService")
public class NotaPedidoCursoService implements INotaPedidoCursoService {
	
	@Autowired
	@Qualifier("notaPedidoCursoRepository")
	private INotaPedidoCursoRepository notaPedidoCursoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<NotaPedidoCurso> getAll() {
		return notaPedidoCursoRepository.findAll();
	}

	@Override
	public NotaPedidoCursoModel insertOrUpdate(NotaPedidoCursoModel notaPedidoCursoModel) {
		NotaPedidoCurso notaPedidoCurso = notaPedidoCursoRepository.save(modelMapper.map(notaPedidoCursoModel, NotaPedidoCurso.class));
		return modelMapper.map(notaPedidoCurso, NotaPedidoCursoModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			notaPedidoCursoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public NotaPedidoCurso findByidNotaPedidoCurso(int id) {
		return notaPedidoCursoRepository.findByidNotaPedidoCurso(id);
	}

}
