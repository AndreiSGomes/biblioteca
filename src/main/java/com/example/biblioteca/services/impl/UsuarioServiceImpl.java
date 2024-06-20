package com.example.biblioteca.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.dto.UsuarioDto;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import com.example.biblioteca.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioDto criarUsuarioDto(UsuarioDto usuarioDto) {
		
		Usuario loginExiste = usuarioRepository.findByLogin(usuarioDto.login());
		if(loginExiste != null) {
			throw new RuntimeException("Login já existe!");
		}
		
		Usuario usuario = new Usuario(usuarioDto.nome(), usuarioDto.login(), usuarioDto.email(), usuarioDto.senha());
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getEmail(), novoUsuario.getSenha());
	}
	

}
