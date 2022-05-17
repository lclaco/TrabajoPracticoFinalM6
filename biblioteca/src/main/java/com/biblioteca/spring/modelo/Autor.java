package com.biblioteca.spring.modelo;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Autor {

	
	@Min(0)
	private Long id;
	@Size(min =3, max = 20)
	private String nombre;
	@Size(min =3, max = 20)
	private String apellido;
	@Size(min =3, max = 20)
	private String nacionalidad;
	@Min(value = 0, message="el valor no puede ser 0")
	private LocalDate fechaNacimiento;
	
	
	public Autor() {
		super();
	}


	public Autor(@Size(min = 3, max = 20) String nombre, @Size(min = 3, max = 20) String apellido,
			@Size(min = 3, max = 20) String nacionalidad,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}


	public Autor(@Min(0) Long id, @Size(min = 3, max = 20) String nombre, @Size(min = 3, max = 20) String apellido,
			@Size(min = 3, max = 20) String nacionalidad,
			@Min(value = 0, message = "el valor no puede ser 0") LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
