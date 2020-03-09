package com.concesionario.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.concesionario.negocio.Administradores;
import com.concesionario.negocio.Comerciales;
import com.concesionario.negocio.Concesionario;

@Controller
public class RutasAdministradores {
	
	@Autowired
	private AdministradoresDAO administradorDAO;
	@Autowired
	private ConcesionarioDAO concesionarioDAO;
	

	/*Create*/
	@GetMapping("/administrador/agregar")
	public ModelAndView addAdministrador() {
		ModelAndView model= new ModelAndView();
		model.addObject("administrador" , new Administradores());
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario",listaConcesionarios);
		model.setViewName("agregarAdministrador");
		return model;
	}
	
	@PostMapping("/administrador/post")
	public String recojerDatos(@ModelAttribute Administradores administrador) {
		System.out.println(administrador.getConcesionarios());
		administradorDAO.save(administrador);
		return "redirect:/administrador/lista";
	}
	
	
	
	/*Read*/
	@GetMapping("/administrador/lista")
	public ModelAndView mostrarDatos() {
		ModelAndView model = new ModelAndView();
		List <Administradores> ListaAdministradores = (List<Administradores>) administradorDAO.findAll();
		model.addObject("listaadministrador", ListaAdministradores);
		model.setViewName("listaAdministrador");
		return model;
	}
	
	
	/*Delete*/
	@GetMapping("/administrador/borrar/{id}")
	public String borrarDatos(@PathVariable Integer id) {
		administradorDAO.deleteById(id);
		return "redirect:/administrador/lista";
	}
	
	
	/*Update*/
	@GetMapping("/administrador/editar/{id}")
	public ModelAndView editarDatos(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Optional<Administradores> admin = administradorDAO.findById(id);
		Administradores administrador = new Administradores();
		administrador = admin.get();
		model.addObject("administrador", administrador);
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario",listaConcesionarios);
		model.setViewName("editarAdministrador");
		return model;
	}
	
}
