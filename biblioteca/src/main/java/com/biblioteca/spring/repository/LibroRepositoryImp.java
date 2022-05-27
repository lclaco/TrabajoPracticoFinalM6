package com.biblioteca.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biblioteca.spring.modelo.Autor;
import com.biblioteca.spring.modelo.Libro;


@Repository
public class LibroRepositoryImp implements LibroRepository{

	
	private static final String TABLA = "libro";
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	@Autowired
	AutorRepository autorRepository;
	
	public Libro makeObject(ResultSet rs, int row) throws SQLException {
		Long id = rs.getLong("autor_id");
		Autor autor = autorRepository.findById((long)id);
		return new Libro(rs.getLong("id"), rs.getString("titulo"), rs.getString("edicion"), rs.getString("editorial"),rs.getObject("ano", LocalDate.class),autor);
	}
	
	@Override
	public List<Libro> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Libro findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Libro libro) {
		String sql = String.format("INSERT INTO %s(titulo,edicion,editorial,ano,autor_id)  VALUES(?, ?, ?, ?,?)", TABLA);
		jdbcTemplate.update(sql, libro.getTitulo(),libro.getEdicion(),libro.getEditorial(),libro.getAno(),libro.getAutor().getId());
	}

	@Override
	public void edit(Libro libro) {
		String sql = String.format("UPDATE %s SET titulo = ?, SET edicion = ?, SET editorial = ?, SET ano = ?, SET autor_id = ? WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, libro.getTitulo(), libro.getEdicion(), libro.getEditorial(), libro.getAno(), libro.getAutor().getId());
	}

	@Override
	public void delete(Long id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, id);
	
	}

}
