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
	private String autor;
	@Size(min =3, max = 20)
	private String edicion;
	@Size(min =3, max = 100)
	private String editorial;
	@Min(value = 0, message="el valor no puede ser 0")
	private LocalDate año;
	
	public Libro() {
		super();
	}

	public Libro(@Size(min = 3, max = 50) String titulo, @Size(min = 3, max = 20) String autor,
			@Size(min = 3, max = 20) String edicion, @Size(min = 3, max = 100) String editorial,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate año) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.edicion = edicion;
		this.editorial = editorial;
		this.año = año;
	}

	public Libro(@Min(0) Long id, @Size(min = 3, max = 50) String titulo, @Size(min = 3, max = 20) String autor,
			@Size(min = 3, max = 20) String edicion, @Size(min = 3, max = 100) String editorial,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate año) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.edicion = edicion;
		this.editorial = editorial;
		this.año = año;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public LocalDate getAño() {
		return año;
	}

	public void setAño(LocalDate año) {
		this.año = año;
	}
	
	
	
}
