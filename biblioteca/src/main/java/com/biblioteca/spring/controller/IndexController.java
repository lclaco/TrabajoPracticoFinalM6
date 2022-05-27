package com.biblioteca.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "/", "/Inicio" })
	public String index() {
		return "index";
	}

}
