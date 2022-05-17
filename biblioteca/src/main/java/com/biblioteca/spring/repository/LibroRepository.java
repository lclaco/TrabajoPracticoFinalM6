package com.biblioteca.spring.repository;

import java.util.List;

import com.biblioteca.spring.modelo.Libro;

public interface LibroRepository {

	public List<Libro> findAll();
	public Libro findById(int id);
	public void create(Libro libro);
	public void edit(Libro libro);
	public void delete(int id);
	
}
