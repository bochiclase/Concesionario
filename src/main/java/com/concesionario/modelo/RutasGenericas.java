package com.concesionario.modelo;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasGenericas {

	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/login")
	public String seguridad(HttpSession sesion) {
		return "start";
	}
	
	@GetMapping("/logout")
	public String finalizar(Authentication authentication) {
		
		return "ok";
	}
	
}
