package com.example.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
		public ModelAndView logar() {
			ModelAndView mv = new ModelAndView("login");
			return mv;
	}
	
	@GetMapping("/novo-usuario")
		public ModelAndView cadastrar() {
			ModelAndView mv = new ModelAndView("newUser");
			return mv;
	}
}