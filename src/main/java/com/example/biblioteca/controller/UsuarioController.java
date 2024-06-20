package com.example.biblioteca.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.dto.UsuarioDto;
import com.example.biblioteca.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	private UsuarioDto criarUsuario(@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.criarUsuarioDto(usuarioDto);
	}
}