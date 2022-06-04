package com.unla.unlaGAulas.service;

import java.util.List;


import com.unla.unlaGAulas.entities.NotaPedidoFinal;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;


public interface INotaPedidoFinalService {
	
	public List<NotaPedidoFinal> getAll();
	
	public NotaPedidoFinal findByidNotaPedidoFinal(int id);
	
	public NotaPedidoFinalModel insertOrUpdate(NotaPedidoFinalModel notaPedidoFinalModel);
	
	public boolean remove(int id);

}
