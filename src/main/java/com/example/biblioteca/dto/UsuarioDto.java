package com.example.biblioteca.dto;

import com.example.biblioteca.enums.RoleEnum;

public record UsuarioDto (
	String nome,
	String login,
	String email,
	String senha,
	RoleEnum role
) {}

