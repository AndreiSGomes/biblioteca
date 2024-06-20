package com.example.biblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@NotNull
	private String titulo;
	
	@NotBlank
	@NotNull
	private String autor;
	
	@NotBlank
	private String categoria;
	
	@Enumerated(EnumType.STRING)
	private LivroStatus status;
	
	@NotBlank
	@Lob
	private String descricao;
	
	private String isbn;
	private String editora;
	private String numPag;
	private String ano;
	
	
	public Livro() { }
	
	public Livro(String titulo, String autor, String categoria, LivroStatus status) {
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.status = status;
	}
//	public Livro(String titulo, String autor, String categoria, LivroStatus status, String editora, String isbn, String ano, String numPag) {
//		this.titulo = titulo;
//		this.autor = autor;
//		this.categoria = categoria;
//		this.status = status;
//		this.editora = editora;
//		this.isbn = isbn;
//		this.ano = ano;
//		this.numPag = numPag;
//	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LivroStatus getStatus() {
		return status;
	}

	public void setStatus(LivroStatus status) {
		this.status = status;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNumPag() {
		return numPag;
	}

	public void setNumPag(String numPag) {
		this.numPag = numPag;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	
}
