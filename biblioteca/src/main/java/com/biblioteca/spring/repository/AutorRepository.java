package com.biblioteca.spring.repository;

import java.util.List;

import com.biblioteca.spring.modelo.Autor;

public interface AutorRepository {
	
	public List<Autor> findAll();
	public Autor findById(Long id);
	public void create(Autor autor);
	public void edit(Autor autor);
	public void delete(Long id);
}
