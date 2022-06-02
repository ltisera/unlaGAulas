package com.unla.unlaGAulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.unlaGAulas.entities.User;
import com.unla.unlaGAulas.helpers.ViewRouteHelper;
import com.unla.unlaGAulas.models.NotaPedidoCursoModel;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;
import com.unla.unlaGAulas.service.INotaPedidoCursoService;
import com.unla.unlaGAulas.service.INotaPedidoFinalService;
import com.unla.unlaGAulas.services.implementation.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("notaPedidoFinalService")
	private INotaPedidoFinalService notaPedidoFinalService;
	
	@Autowired
	@Qualifier("notaPedidoCursoService")
	private INotaPedidoCursoService notaPedidoCursoService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/index")
	public ModelAndView indexPrueba() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_INDEX);
		modelAndView.addObject("notaPedidoFinales", notaPedidoFinalService.getAll());
		modelAndView.addObject("notaPedidoFinal", new NotaPedidoFinalModel());
		modelAndView.addObject("notaPedidoCursos", notaPedidoCursoService.getAll());
		modelAndView.addObject("notaPedidoCurso", new NotaPedidoCursoModel());
		modelAndView.addObject("usuarios", userService.getAll());
		modelAndView.addObject("usuario", new User());
		
		return modelAndView;
	}
	
	@GetMapping("/adminFinal")
	public ModelAndView adminFinal() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_FINAL);
		modelAndView.addObject("notaPedidoFinales", notaPedidoFinalService.getAll());
		modelAndView.addObject("notaPedidoFinal", new NotaPedidoFinalModel());
		
		return modelAndView;
	}
	
	@GetMapping("/adminCurso")
	public ModelAndView adminCurso() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_CURSO);
		modelAndView.addObject("notaPedidoCursos", notaPedidoCursoService.getAll());
		modelAndView.addObject("notaPedidoCurso", new NotaPedidoCursoModel());
		
		return modelAndView;
	}
	
	@GetMapping("/adminUser")
	public ModelAndView adminUser() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_USER);
		modelAndView.addObject("usuarios", userService.getAll());
		modelAndView.addObject("usuario", new User());
		
		return modelAndView;
	}
}
