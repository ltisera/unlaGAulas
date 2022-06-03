package com.unla.unlaGAulas.repositories;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.unlaGAulas.entities.Espacio;

@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Serializable>{
	
	public abstract Espacio findByidEspacio(int id);
	
	@Query("SELECT e FROM Espacio e WHERE e.fecha = :fecha AND e.turno = :turno AND e.aula.idAula = :idAula")
	public abstract Espacio findExactDate(@Param("fecha") LocalDate fecha,@Param("turno") char turno,@Param("idAula") int idAula);
	
}
