package com.biblioteca.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biblioteca.spring.modelo.Autor;


@Repository
public class AutorRepositoryImp implements AutorRepository{

	private static final String TABLA = "autor";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public Autor makeObject(ResultSet rs, int row) throws SQLException {		
		return new Autor(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellido"),rs.getString("nacionalidad"), rs.getObject("fechaNacimiento", LocalDate.class));
	}
	
	@Override
	public List<Autor> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Autor findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Autor autor) {
		String sql = String.format("INSERT INTO %s(nombre,apellido,nacionalidad, fechaNacimiento) VALUES(?, ?, ?, ?)", TABLA);
		jdbcTemplate.update(sql, autor.getNombre(), autor.getApellido(),autor.getNacionalidad(),autor.getFechaNacimiento());
	}

	@Override
	public void edit(Autor autor) {
		String sql = String.format("UPDATE %s SET nombre = ?,apellido = ?,nacionalidad = ?, fechaNacimiento = ?, WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, autor.getNombre(), autor.getApellido(),autor.getNacionalidad(),autor.getFechaNacimiento());
	}

	@Override
	public void delete(Long id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, id);
	}

}
