package com.concesionario.modelo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.concesionario.negocio.Administradores;
import com.concesionario.negocio.Comerciales;
import com.concesionario.negocio.Concesionario;
import com.concesionario.negocio.Rol;

@Controller
public class RutasAdministradores {
	
	@Autowired
	private AdministradoresDAO administradorDAO;
	@Autowired
	private ConcesionarioDAO concesionarioDAO;
	@Autowired
	private RolDAO rolDAO;
	

	/*Create*/
	@GetMapping("/administrador/agregar")
	public ModelAndView addAdministrador() {
		ModelAndView model= new ModelAndView();
		model.addObject("administrador" , new Administradores());
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		List <Rol> listaRol =(List<Rol>) rolDAO.findAll();
		model.addObject("listaroles", listaRol);
		model.addObject("listaConcesionario",listaConcesionarios);
		model.setViewName("agregarAdministrador");
		return model;
	}
	
	@PostMapping("/administrador/post")
	public String recojerDatos(@ModelAttribute Administradores administrador) {
		System.out.println(administrador.getConcesionarios());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		administrador.setPass(passwordEncoder.encode(administrador.getPass()));
		administradorDAO.save(administrador);
		return "redirect:/administrador/lista";
	}
	
	@PostMapping("/administrador/postEditar")
	public String recojerDatosEditar(@ModelAttribute Administradores administrador) {
		System.out.println(administrador.getConcesionarios());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		administrador.setPass(passwordEncoder.encode(administrador.getPass()));
		administradorDAO.save(administrador);
		return "redirect:/administrador/lista";
	}
	
	
	
	/*Read*/
	@GetMapping("/administrador/lista")
	public ModelAndView mostrarDatos(HttpSession sesion) {
		ModelAndView model = new ModelAndView();
		List <Administradores> ListaAdministradores = (List<Administradores>) administradorDAO.findAll();
		model.addObject("listaadministrador", ListaAdministradores);
		model.setViewName("listaAdministrador");
		return model;
	}
	
	
	/*Delete*/
	@GetMapping("/administrador/borrar/{id}")
	public String borrarDatos(@PathVariable String id) {
		administradorDAO.deleteById(id);
		return "redirect:/administrador/lista";
	}
	
	
	/*Update*/
	@GetMapping("/administrador/editar/{id}")
	public ModelAndView editarDatos(@PathVariable String id) {
		ModelAndView model = new ModelAndView();
		Optional<Administradores> admin = administradorDAO.findById(id);
		Administradores administrador = new Administradores();
		administrador = admin.get();
		model.addObject("administrador", administrador);
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario",listaConcesionarios);
		List <Rol> listaRol =(List<Rol>) rolDAO.findAll();
		model.addObject("listaroles", listaRol);
		model.setViewName("editarAdministrador");
		return model;
	}
	
	
	/*Consulta propia*/
	@GetMapping("/administrador/consulta")
	public ModelAndView consulta() {
		ModelAndView model = new ModelAndView();
		List <Administradores> listaAdministradores = administradorDAO.buscarPorTelefono("123123123");
		System.out.println(listaAdministradores);
		model.addObject("listaTelefono", listaAdministradores );
		model.setViewName("consulta");
		return model;
	}
	
}
