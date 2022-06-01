package com.unla.unlaGAulas.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.unla.unlaGAulas.entities.NotaPedidoFinal;

@Repository("notaPedidoFinalRepository")
public interface INotaPedidoFinalRepository extends JpaRepository<NotaPedidoFinal, Serializable> {
	
	public abstract NotaPedidoFinal findByidNotaPedidoFinal(int id);
	
}
