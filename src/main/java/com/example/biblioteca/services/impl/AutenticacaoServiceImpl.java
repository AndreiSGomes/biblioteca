package com.example.biblioteca.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.biblioteca.dto.AuthDto;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import com.example.biblioteca.services.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(login);
	}
	
	@Override
	public String obterToken(AuthDto authDto) {
		Usuario usuario = usuarioRepository.findByLogin(authDto.login());
		return geraTokenJwt(usuario);
	}
	
	public String geraTokenJwt(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("my-secret");

			return JWT.create()
					.withIssuer("auth-api")
					.withSubject(usuario.getLogin())
					.withExpiresAt(geraDataExpiracao())
					.sign(algorithm);
			
			
		} catch(JWTCreationException exception) {
			throw new RuntimeException("Erro ao tentar gerar o token!" + exception.getMessage());
		}
	}
	
	public String validaTokenJwt(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("my-secret");
			
			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build()
					.verify(token)
					.getSubject();
		} catch(JWTVerificationException exception) {
			return "";
		}
	}

	private Instant geraDataExpiracao() {
		return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
	}

}
