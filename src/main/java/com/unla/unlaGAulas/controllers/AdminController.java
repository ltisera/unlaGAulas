package com.unla.unlaGAulas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.unlaGAulas.entities.Espacio;
import com.unla.unlaGAulas.entities.NotaPedidoCurso;
import com.unla.unlaGAulas.entities.NotaPedidoFinal;
import com.unla.unlaGAulas.entities.User;
import com.unla.unlaGAulas.helpers.ViewRouteHelper;
import com.unla.unlaGAulas.models.NotaPedidoCursoModel;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;
import com.unla.unlaGAulas.service.IEspacioService;
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
	
	@Autowired
	@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
		modelAndView.addObject("espacio", espacioService.findExactDate(LocalDate.of(2022, 3, 1), 'M', 1));
		
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
	
	@GetMapping("/crearEspacioFinal/{id}")
	public ModelAndView adminFinalEspacio(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ADMIN_FINAL_ESPACIO);
		NotaPedidoFinal notaPedidoFinal = notaPedidoFinalService.findByidNotaPedidoFinal(id);
		mAV.addObject("notaPedidoFinal", modelMapper.map(notaPedidoFinal, NotaPedidoFinalModel.class));
		boolean ocupado = false;
		Espacio espacio = espacioService.findExactDate(notaPedidoFinal.getFechaExamen(), notaPedidoFinal.getTurno(), notaPedidoFinal.getAula().getIdAula());
		if (espacio!=null && !espacio.isLibre()) {
			ocupado = true;
		}
		mAV.addObject("ocupado",ocupado);
		return mAV;
	}
	
	@PostMapping("/createEspacioFinal")
	public RedirectView createEspacioFinal(@ModelAttribute("notaPedidoFinal") NotaPedidoFinalModel notaPedidoFinalModel) {
		notaPedidoFinalService.insertOrUpdate(notaPedidoFinalModel);
		Espacio espacio = espacioService.findExactDate(notaPedidoFinalModel.getFechaExamen(), notaPedidoFinalModel.getTurno(), notaPedidoFinalModel.getAula().getIdAula());
		Espacio nuevoEspacio = null;
		if (espacio != null) {
			nuevoEspacio = new Espacio(espacio.getIdEspacio(), espacio.getFecha(), espacio.getTurno(), espacio.getAula(), false);
		} else {
			nuevoEspacio = new Espacio(notaPedidoFinalModel.getFechaExamen(), notaPedidoFinalModel.getTurno(), notaPedidoFinalModel.getAula(), false);
		}
		espacioService.insertOrUpdate(nuevoEspacio);
		return new RedirectView(ViewRouteHelper.ADMIN_ROOT_FINAL);
	}
	
	@GetMapping("/crearEspacioCurso/{id}")
	public ModelAndView adminCursoEspacio(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ADMIN_CURSO_ESPACIO);
		NotaPedidoCurso notaPedidoCurso = notaPedidoCursoService.findByidNotaPedidoCurso(id);
		mAV.addObject("notaPedidoCurso", modelMapper.map(notaPedidoCurso, NotaPedidoCursoModel.class));
		boolean ocupado = false;
		int i = 0;
		Espacio espacio = null;
		char turno = notaPedidoCurso.getTurno();
		int idAula = notaPedidoCurso.getAula().getIdAula();
		List <LocalDate> listaDeFechas = new ArrayList<>(notaPedidoCurso.getFechasCursada());
		while (!ocupado && i<listaDeFechas.size()) {
			espacio = espacioService.findExactDate(listaDeFechas.get(i), turno, idAula);
			if (espacio!=null && !espacio.isLibre()) {
				ocupado = true;
			}
			i++;
		}
		mAV.addObject("ocupado",ocupado);
		return mAV;
	}
	
	@PostMapping("/createEspacioCurso")
	public RedirectView createEspacioCurso(@ModelAttribute("notaPedidoCurso") NotaPedidoCursoModel notaPedidoCursoModel) {
		notaPedidoCursoService.insertOrUpdate(notaPedidoCursoModel);
		Espacio espacio = null;
		Espacio nuevoEspacio = null;
		List <LocalDate> listaDeFechas = new ArrayList<>(notaPedidoCursoModel.getFechasCursada());
		for (int i = 0; i<notaPedidoCursoModel.getFechasCursada().size();i++) {
			espacio = espacioService.findExactDate(listaDeFechas.get(i), notaPedidoCursoModel.getTurno(), notaPedidoCursoModel.getAula().getIdAula());
			if (espacio != null) {
				nuevoEspacio = new Espacio(espacio.getIdEspacio(), espacio.getFecha(), espacio.getTurno(), espacio.getAula(), false);
			} else {
				nuevoEspacio = new Espacio(listaDeFechas.get(i), notaPedidoCursoModel.getTurno(), notaPedidoCursoModel.getAula(), false);
			}
			espacioService.insertOrUpdate(nuevoEspacio);
		}
		return new RedirectView(ViewRouteHelper.ADMIN_ROOT_CURSO);
	}


}
