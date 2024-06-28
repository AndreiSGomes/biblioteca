package com.example.biblioteca.dto;

import com.example.biblioteca.enums.RoleEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequisicao {
	
	@NotBlank
	@NotNull
	private String nome;
	@NotBlank
	@NotNull
	private String login;
	private String email;
	@NotBlank
	@NotNull
	private String senha;
	private RoleEnum role;
	
	public UsuarioRequisicao() {
		
	}
	public UsuarioRequisicao(String nome, String login, String email, String senha, RoleEnum role) {
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.role = role;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	public RoleEnum getRole() {
		return role;
	}


	
}
