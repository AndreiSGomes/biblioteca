package com.example.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.LivroStatus;
import com.example.biblioteca.repository.LivroRepository;

import jakarta.validation.Valid;

@Controller
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		List<Livro> livros = livroRepository.findAll();
		ModelAndView mv = new ModelAndView("livros/index");
		mv.addObject("livros", livros);
		return mv;
	}

	@GetMapping("/novo-livro")
	public ModelAndView novo(Livro livro) {
		ModelAndView mv = new ModelAndView("livros/new");
		mv.addObject("statusLivro", LivroStatus.values());
		return mv;
	}

	@PostMapping("/novo-livro")
	public ModelAndView cadastrarLivro(@Valid Livro livro, BindingResult bindingResult) {
		Livro novoLivro = livro;
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("livros/new");
			mv.addObject("statusLivro", LivroStatus.values());
			return mv;
		} else {
			livroRepository.save(novoLivro);
			return new ModelAndView("redirect:/");
		}
	}

	@GetMapping("/livro-{id}")
	public ModelAndView detalheLivro(@PathVariable Integer id) {
		Optional<Livro> optional = livroRepository.findById(id);

		if (optional.isPresent()) {
			Livro livro = optional.get();
			ModelAndView mv = new ModelAndView("livros/detail");
			mv.addObject("livro", livro);
			return mv;
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@GetMapping("/editar-livro-{id}")
	public ModelAndView editarLivro(@PathVariable Integer id, Livro livroEdit) {
		Optional<Livro> optional = livroRepository.findById(id);

		if (optional.isPresent()) {
			Livro livro = optional.get();
			livroEdit.setTitulo(livro.getTitulo());
			livroEdit.setAutor(livro.getAutor());
			livroEdit.setCategoria(livro.getCategoria());
			livroEdit.setStatus(livro.getStatus());
			livroEdit.setDescricao(livro.getDescricao());
			livroEdit.setEditora(livro.getEditora());
			livroEdit.setIsbn(livro.getIsbn());
			livroEdit.setAno(livro.getAno());
			livroEdit.setNumPag(livro.getNumPag());

			ModelAndView mv = new ModelAndView("livros/edit");
			mv.addObject("statusLivro", LivroStatus.values());
			return mv;
		} else {
			return new ModelAndView("redirect:/editar-livro");
		}
	}

	@PostMapping("livro-{id}")
	public ModelAndView editarLivro(@PathVariable Integer id, @Valid Livro livroEditado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("livros/edit");
			mv.addObject("statusLivro", LivroStatus.values());

			return mv;

		} else {
			Optional<Livro> optional = livroRepository.findById(id);

			if (optional.isPresent()) {
				Livro livro = optional.get();
				livro.setTitulo(livroEditado.getTitulo());
				livro.setAutor(livroEditado.getAutor());
				livro.setCategoria(livroEditado.getCategoria());
				livro.setStatus(livroEditado.getStatus());
				livro.setDescricao(livroEditado.getDescricao());
				livro.setEditora(livroEditado.getEditora());
				livro.setIsbn(livroEditado.getIsbn());
				livro.setAno(livroEditado.getAno());
				livro.setNumPag(livroEditado.getNumPag());

				livroRepository.save(livro);

				return new ModelAndView("redirect:/livro-" + livro.getId());
			} else {
				return new ModelAndView("redirect:/");
			}
		}
	}

	@GetMapping("/excluir-livro-{id}")
	public String excluirLivro(@PathVariable Integer id) {
		try {
			livroRepository.deleteById(id);
			return "redirect:/";
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return "redirect:/";
		}
	}
	
	@PostMapping("/")
		public ModelAndView buscarLivro(@RequestParam("buscaTitulo")  String buscaTitulo) {
		ModelAndView mv = new ModelAndView("livros/index");
		List <Livro> livro = livroRepository.findByTitulo(buscaTitulo);
		mv.addObject("livros", livro);
		return mv;
		
	}
	

}
