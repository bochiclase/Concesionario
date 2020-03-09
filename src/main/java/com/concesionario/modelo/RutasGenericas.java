package com.concesionario.modelo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasGenericas {

	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
}
