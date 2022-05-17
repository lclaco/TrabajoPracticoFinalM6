package com.biblioteca.spring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.spring.modelo.Autor;

@Repository
public class AutorRepositoryImp implements AutorRepository{

	@Override
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
