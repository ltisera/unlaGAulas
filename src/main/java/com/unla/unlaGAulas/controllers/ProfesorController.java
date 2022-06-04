package com.unla.unlaGAulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.unlaGAulas.entities.Aula;
import com.unla.unlaGAulas.entities.Materia;

import com.unla.unlaGAulas.helpers.ViewRouteHelper;
import com.unla.unlaGAulas.models.NotaPedidoCursoModel;
import com.unla.unlaGAulas.models.NotaPedidoFinalModel;
import com.unla.unlaGAulas.repositories.IUserRepository;
import com.unla.unlaGAulas.service.IAulaService;
import com.unla.unlaGAulas.service.IMateriaService;
import com.unla.unlaGAulas.service.INotaPedidoCursoService;
import com.unla.unlaGAulas.service.INotaPedidoFinalService;
import com.unla.unlaGAulas.services.implementation.UserService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	@Qualifier("notaPedidoFinalService")
	private INotaPedidoFinalService notaPedidoFinalService;
	
	@Autowired
	@Qualifier("notaPedidoCursoService")
	private INotaPedidoCursoService notaPedidoCursoService;
	
	@Autowired
	@Qualifier("materiaService")
	private IMateriaService materiaService;
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	@Autowired
	@Qualifier("userRepository")
	IUserRepository userRepository;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/index")
	public ModelAndView indexPrueba() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PROFESOR_INDEX);
		return modelAndView;
	}
	
	@GetMapping("/newFinal")
	public ModelAndView createFinal() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFESOR_NEWFINAL);
		mAV.addObject("notaPedidoFinal", new NotaPedidoFinalModel());
		mAV.addObject("materias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		mAV.addObject("aulas", aulaService.getAll());
		mAV.addObject("aula", new Aula());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("user", user);
		return mAV;
	}
	
	@PostMapping("/createFinal")
	public RedirectView createFinal(@ModelAttribute("notaPedidoFinal") NotaPedidoFinalModel notaPedidoFinalModel) {
		notaPedidoFinalService.insertOrUpdate(notaPedidoFinalModel);
		return new RedirectView(ViewRouteHelper.PROFESOR_ROOT);
	}
	
	@GetMapping("/newCurso")
	public ModelAndView createCurso() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFESOR_NEWCURSO);
		mAV.addObject("notaPedidoCurso", new NotaPedidoCursoModel());
		mAV.addObject("materias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		mAV.addObject("aulas", aulaService.getAll());
		mAV.addObject("aula", new Aula());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("user", user);
		return mAV;
	}
	
	@PostMapping("/agregarFechas")
	public ModelAndView agregarFechas(@ModelAttribute("notaPedidoCurso") NotaPedidoCursoModel notaPedidoCursoModel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFESOR_FECHAS);
		mAV.addObject("notaPedidoCurso", notaPedidoCursoModel);
		return mAV;
	}
	
	@PostMapping("/createCurso")
	public RedirectView createCurso(@ModelAttribute("notaPedidoCurso") NotaPedidoCursoModel notaPedidoCursoModel) {
		notaPedidoCursoService.insertOrUpdate(notaPedidoCursoModel);
		return new RedirectView(ViewRouteHelper.PROFESOR_ROOT);
	}
	
	@GetMapping("/profesorUser")
	public ModelAndView profesorUser() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFESOR_USER);
		mAV.addObject("usuarios", userService.getAll());
		mAV.addObject("usuario", new com.unla.unlaGAulas.entities.User());
		
		return mAV;
	}
	
}
