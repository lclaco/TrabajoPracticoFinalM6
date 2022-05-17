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

import com.biblioteca.spring.modelo.Libro;
import com.biblioteca.spring.repository.LibroRepository;



@Controller
@RequestMapping("/libro")
public class LibroController {

	
	@Autowired
	LibroRepository libroRepository;
	
	@GetMapping("/nueva")
	public String libroNuevo(Libro libro) {
		return "libro/form";
	}
	
	@GetMapping("/editar/{id}")
	public String autorEditar(@PathVariable int id, Model modelo) {
		Libro libros = libroRepository.findById(id);
		modelo.addAttribute("libros", libros);
		return "libro/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String alumnoEliminar(@PathVariable int id) {
		libroRepository.delete(id);
		return "redirect:/libro/listado";
	}
	
	@GetMapping("/listado")
	public String alumnoListado(Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libros", libros);
		return "libro/listado";
	}
	
	@PostMapping("/procesar")
	public String carreraProcesar(@Valid Libro libro, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "libro/form";
		}
		
		if( libro.getId() > 0) {
			libroRepository.edit(libro);
		} else {
			libroRepository.create(libro);	
		}
		return "redirect:/carrera/listado";
	}
	
	
	
}
