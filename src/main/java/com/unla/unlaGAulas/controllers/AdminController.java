package com.unla.unlaGAulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.unlaGAulas.helpers.ViewRouteHelper;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;
import com.unla.unlaGAulas.service.INotaPedidoFinalService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("notaPedidoFinalService")
	private INotaPedidoFinalService notaPedidoFinalService;
	
	@GetMapping("/index")
	public ModelAndView indexPrueba() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_INDEX);
		modelAndView.addObject("notaPedidoFinales", notaPedidoFinalService.getAll());
		modelAndView.addObject("notaPedidoFinal", new NotaPedidoFinalModel());
		return modelAndView;
	}
	
	
	
}
