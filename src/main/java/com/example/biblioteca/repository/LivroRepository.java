package com.example.biblioteca.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Livro;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
	@Query("SELECT l FROM Livro l WHERE l.titulo ILIKE %?1%")
	List<Livro> findByTitulo(String titulo); 
}
