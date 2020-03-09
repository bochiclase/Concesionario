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

import com.concesionario.negocio.Comerciales;
import com.concesionario.negocio.Concesionario;

@Controller
public class RutasComerciales {
	
	@Autowired
	private ComercialesDAO comercialDAO;
	@Autowired
	private ConcesionarioDAO concesionarioDAO;
	

	/*Create*/
	@GetMapping("/comercial/agregar")
	public ModelAndView addComercial() {
		ModelAndView model= new ModelAndView();
		model.addObject("comercial" , new Comerciales());
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario",listaConcesionarios);
		model.setViewName("agregarComercial");
		return model;
	}
	
	@PostMapping("/comercial/post")
	public String recojerDatos(@ModelAttribute Comerciales comercial) {
		comercialDAO.save(comercial);
		return "redirect:/comercial/lista";
	}
	
	
	
	/*Read*/
	@GetMapping("/comercial/lista")
	public ModelAndView mostrarDatos() {
		ModelAndView model = new ModelAndView();
		List <Comerciales> ListaComercial = (List<Comerciales>) comercialDAO.findAll();
		model.addObject("listacomercial", ListaComercial);
		model.setViewName("listaComercial");
		return model;
	}
	
	
	/*Delete*/
	@GetMapping("/comercial/borrar/{id}")
	public String borrarDatos(@PathVariable Integer id) {
		comercialDAO.deleteById(id);
		return "redirect:/comercial/lista";
	}
	
	
	/*Update*/
	@GetMapping("/comercial/editar/{id}")
	public ModelAndView editarDatos(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Optional<Comerciales> conce = comercialDAO.findById(id);
		Comerciales comercial = new Comerciales();
		comercial = conce.get();
		model.addObject("comercial", comercial);
		List <Concesionario> listaConcesionarios = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario",listaConcesionarios);
		model.setViewName("editarComercial");
		return model;
	}
	
}
