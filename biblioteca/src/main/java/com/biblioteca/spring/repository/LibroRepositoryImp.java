package com.biblioteca.spring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.spring.modelo.Libro;

@Repository
public class LibroRepositoryImp implements LibroRepository{

	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
