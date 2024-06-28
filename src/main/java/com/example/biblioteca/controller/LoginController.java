package com.example.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.biblioteca.dto.AuthRequisicao;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
		public ModelAndView logar(AuthRequisicao authRequisicao) {
			ModelAndView mv = new ModelAndView("login");
			return mv;
	}

	
}