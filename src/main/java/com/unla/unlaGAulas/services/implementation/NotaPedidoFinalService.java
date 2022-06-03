package com.unla.unlaGAulas.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.unlaGAulas.entities.NotaPedidoFinal;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;
import com.unla.unlaGAulas.repositories.INotaPedidoFinalRepository;
import com.unla.unlaGAulas.service.INotaPedidoFinalService;

@Service("notaPedidoFinalService")
public class NotaPedidoFinalService implements INotaPedidoFinalService {

	@Autowired
	@Qualifier("notaPedidoFinalRepository")
	private INotaPedidoFinalRepository notaPedidoFinalRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<NotaPedidoFinal> getAll() {
		return notaPedidoFinalRepository.findAll();
	}

	@Override
	public NotaPedidoFinalModel insertOrUpdate(NotaPedidoFinalModel notaPedidoFinalModel) {
		NotaPedidoFinal notaPedidoFinal = notaPedidoFinalRepository.save(modelMapper.map(notaPedidoFinalModel, NotaPedidoFinal.class));
		return modelMapper.map(notaPedidoFinal, NotaPedidoFinalModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			notaPedidoFinalRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public NotaPedidoFinal findByidNotaPedidoFinal(int id) {
		return notaPedidoFinalRepository.findByidNotaPedidoFinal(id);
	}
	
}
