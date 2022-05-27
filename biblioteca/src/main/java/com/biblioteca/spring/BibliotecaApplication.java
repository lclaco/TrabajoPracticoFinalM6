package com.biblioteca.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.biblioteca.spring.modelo.Autor;
import com.biblioteca.spring.repository.AutorRepository;



@SpringBootApplication
public class BibliotecaApplication implements WebMvcConfigurer{

	@Autowired
	AutorRepository autorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new Converter<String, Autor>() {

			@Override
			public Autor convert(String idStr) {
				Long id = Long.parseLong(idStr);
				Autor autor = autorRepository.findById(id);
				return autor;
			}
			
		});
	}
}
