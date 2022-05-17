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
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	@Autowired
	LibroRepository libroRepository;
	
	@GetMapping("/nuevo")
	public String autorNuevo(Autor autor, Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libros", libros);
		return "autor/form";
	}
	
	@GetMapping("/editar/{autorId}")
	public String autorEditar(@PathVariable int autorId, Model modelo) {
		Autor autor = autorRepository.findById(autorId);
		modelo.addAttribute("autor", autor);
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libros", libros);
		return "autor/form";
	}
	
	@GetMapping("/eliminar/{autorId}")
	public String alumnoEliminar(@PathVariable int autorId) {
		autorRepository.delete(autorId);
		return "redirect:/autor/listado";
	}
	
	@GetMapping("/listado")
	public String autorListado(Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores", autores);
		return "autor/listado";
	}
	
	@PostMapping("/procesar")
	public String autorProcesar(@Valid Autor autor, BindingResult informeValidacion) {
		
		if( informeValidacion.hasErrors() ) {
			return "autor/form";
		}
		
		if( autor.getId() > 0) {
			autorRepository.edit(autor);
		} else {
			autorRepository.create(autor);	
		}
		return "redirect:/autor/listado";
	}
	
	
	
	
}
