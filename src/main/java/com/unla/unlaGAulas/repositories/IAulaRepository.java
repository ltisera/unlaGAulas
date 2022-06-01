package com.unla.unlaGAulas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.unlaGAulas.entities.Aula;

@Repository("aulaRepository")
public interface IAulaRepository extends JpaRepository<Aula, Serializable>{

	public abstract Aula findByidAula(int id);
	
}
