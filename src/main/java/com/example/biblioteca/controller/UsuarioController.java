package com.example.biblioteca.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.biblioteca.dto.UsuarioDto;
import com.example.biblioteca.dto.UsuarioRequisicao;
import com.example.biblioteca.enums.RoleEnum;
import com.example.biblioteca.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/novo-usuario")
	public ModelAndView novoUsuario(UsuarioRequisicao usuarioRequisicao) {
		ModelAndView mv = new ModelAndView("newUser");
		mv.addObject("roleUsuario", RoleEnum.values());
		return mv;
	}

	@PostMapping("/novo-usuario")
	public ModelAndView cadastrar(@Valid UsuarioRequisicao usuarioRequisicao, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("newUser");
			mv.addObject("roleUsuario", RoleEnum.values());
			return mv;
		} else {
			UsuarioDto usuarioDto = new UsuarioDto(
													usuarioRequisicao.getNome(),
													usuarioRequisicao.getLogin(),
													usuarioRequisicao.getEmail(),
													usuarioRequisicao.getSenha(),
													usuarioRequisicao.getRole());
			usuarioService.criarUsuarioDto(usuarioDto);
			return new ModelAndView("redirect:/novo-usuario");
		}
		
		
		}
	
}