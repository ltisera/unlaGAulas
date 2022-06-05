package com.unla.unlaGAulas.service;

import java.util.List;

import com.unla.unlaGAulas.entities.NotaPedidoCurso;
import com.unla.unlaGAulas.models.NotaPedidoCursoModel;


public interface INotaPedidoCursoService {

	public List<NotaPedidoCurso> getAll();
	
	public NotaPedidoCurso findByidNotaPedidoCurso(int id);
	
	public NotaPedidoCursoModel insertOrUpdate(NotaPedidoCursoModel notaPedidoCursoModel);
	
	public boolean remove(int id);

}
