package com.biblioteca.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.spring.modelo.Autor;
import com.biblioteca.spring.modelo.Libro;
import com.biblioteca.spring.repository.AutorRepository;
import com.biblioteca.spring.repository.LibroRepository;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	AutorRepository autorRepository;

	@Autowired
	LibroRepository libroRepository;
	
	
	@GetMapping("/nuevo")
	public String libroNuevo(Libro libro, Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autor", autores);
		return "libro/form";
	}

	@GetMapping("/editar/{id}")
	public String libroEditar(@PathVariable Long id, Model modelo) {
		Libro libro = libroRepository.findById(id);
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autor", autores);		
		modelo.addAttribute("libro", libro);
		return "libro/form";
	}

	@GetMapping("/eliminar/{id}")
	public String libroEliminar(@PathVariable Long id) {
		libroRepository.delete(id);
		return "redirect:/libro/listar";
	}

	@GetMapping("/listar")
	public String libroListado(Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libro", libros);
		return "libro/listar";
	}

	@PostMapping("/procesar")
	public String libroProcesar(@Valid Libro libro, BindingResult informeValidacion, Model modelo) {
		
		
		if (informeValidacion.hasErrors()) {
			List<Autor> autores = autorRepository.findAll();
			modelo.addAttribute("autor", autores);
			return "libro/form";
		}
		if (libro.getId() == null || libro.getId() == 0 ) {
			libroRepository.create(libro);
		} else {
			libroRepository.edit(libro);
		}
		return "redirect:/libro/listar";
	}

}
