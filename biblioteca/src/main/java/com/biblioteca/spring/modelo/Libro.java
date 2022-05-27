package com.biblioteca.spring.modelo;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Libro {

	@Min(0)
	private Long id;
	@Size(min =3, max = 50)
	private String titulo;
	@Size(min =3, max = 20)	
	private String edicion;
	@Size(min =3, max = 100)
	private String editorial;
	//@Past() buscar para validar fechas
	private LocalDate ano;
	private Autor autor;
	
	public Libro() {
		super();
	}

	public Libro(@Size(min = 3, max = 50) String titulo, @Size(min = 3, max = 20) String edicion,
			@Size(min = 3, max = 100) String editorial,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate ano, Autor autor) {
		super();
		this.titulo = titulo;
		this.edicion = edicion;
		this.editorial = editorial;
		this.ano = ano;
		this.autor = autor;
	}

	public Libro(@Min(0) Long id, @Size(min = 3, max = 50) String titulo, @Size(min = 3, max = 20) String edicion,
			@Size(min = 3, max = 100) String editorial,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate ano, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edicion = edicion;
		this.editorial = editorial;
		this.ano = ano;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getAno() {
		return ano;
	}

	public void setAno(LocalDate ano) {
		this.ano = ano;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	
}
