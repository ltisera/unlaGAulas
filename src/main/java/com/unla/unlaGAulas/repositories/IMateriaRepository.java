package com.unla.unlaGAulas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.unlaGAulas.entities.Materia;

@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Serializable> {

	public abstract Materia findByidMateria(int id);

}
