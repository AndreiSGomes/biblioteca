//package com.example.biblioteca.config.security;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.example.biblioteca.model.Usuario;
//
//@Service
//public class TokenService {
//	
//	@Value("${api.security.secreto")
//	private String secreto;
//	
//	public String gerarToken(Usuario usuario) {
//		try {
//			Algorithm algorithm = Algorithm.HMAC256(secreto);
//			
//			String token = JWT.create()
//					.withIssuer("login-auth-api")
//					.withSubject(usuario.getEmail())
//					.withExpiresAt(this.gerarDataExpiracao())
//					.sign(algorithm);
//				return token;
//					
//		} catch (JWTCreationException exception ) { 
//			throw new RuntimeException("Erro de autenticação");
//		}
//	}
//	
//	
//	public String validarToken(String token) {
//		try {
//			Algorithm algorithm = Algorithm.HMAC256(secreto);
//			return JWT.require(algorithm)
//					.withIssuer("ligin-authp api")
//					.build()
//					.verify(token)
//					.getSubject();				
//		} catch (JWTVerificationException exception){
//			return null;
//		}
//	}
//	
//	private Instant gerarDataExpiracao() {
//		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//	}
//}
