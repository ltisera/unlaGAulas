package com.unla.unlaGAulas.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.unlaGAulas.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	/*
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("user", user);
		return modelAndView;
	}*/
	
	@GetMapping("/index")
	public RedirectView redirectToRoleIndex() {
		String redireccion = "";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN]")) {
			redireccion = ViewRouteHelper.ADMIN_INDEX;
		} else {
			redireccion = ViewRouteHelper.PROFESOR_INDEX;
		}
		return new RedirectView(redireccion);
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}

}
