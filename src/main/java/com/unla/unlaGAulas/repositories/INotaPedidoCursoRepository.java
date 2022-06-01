package com.unla.unlaGAulas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.unlaGAulas.entities.NotaPedidoCurso;

@Repository("notaPedidoCursoRepository")
public interface INotaPedidoCursoRepository extends JpaRepository<NotaPedidoCurso, Serializable>{
	
	public abstract NotaPedidoCurso findByidNotaPedidoCurso(int id);
	
}
