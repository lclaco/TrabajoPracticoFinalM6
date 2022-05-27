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
import com.biblioteca.spring.repository.AutorRepository;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;

	@GetMapping("/nuevo")
	public String autorNuevo(Autor autor) {
		return "autor/form";
	}

	@GetMapping("/editar/{id}")
	public String autorEditar(@PathVariable Long id, Model modelo) {
		Autor autores = autorRepository.findById(id);
		modelo.addAttribute("autor", autores);
		return "autor/form";
	}

	@GetMapping("/eliminar/{id}")
	public String autorEliminar(@PathVariable Long id) {
		autorRepository.delete(id);
		return "redirect:/autor/listar";
	}

	@GetMapping("/listar")
	public String autorListado(Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autor", autores);
		return "autor/listar";
	}

	@PostMapping("/procesar")
	public String autorProcesar(@Valid Autor autor, BindingResult informeValidacion) {
		if (informeValidacion.hasErrors()) {
			return "autor/form";
		}

		if (autor.getId() == null || autor.getId() == 0) {
			autorRepository.create(autor);
		} else {
			autorRepository.edit(autor);
		}
		return "redirect:/autor/listar";
	}

}
