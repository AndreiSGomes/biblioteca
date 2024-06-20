//package com.example.biblioteca.config.security;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.biblioteca.model.Usuario;
//import com.example.biblioteca.repository.UsuarioRepository;
//
//public class CustomUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UsuarioRepository repository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario usuario = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
//		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>() );
//	
//	}
//
//}
