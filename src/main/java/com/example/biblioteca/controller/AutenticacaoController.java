package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.biblioteca.dto.AuthDto;
import com.example.biblioteca.dto.AuthRequisicao;
import com.example.biblioteca.services.AutenticacaoService;

@RestController
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public String auth(AuthRequisicao authRequisicao) {
		AuthDto authDto = new AuthDto(authRequisicao.getLogin(), authRequisicao.getSenha());
		
		var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
		authenticationManager.authenticate(usuarioAutenticationToken);
		System.out.println("ENTRADA VALIDADA!");
		return autenticacaoService.obterToken(authDto);
	}
	
}
