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

import com.concesionario.negocio.Concesionario;

@Controller
public class RutasConcesionarios {
	
	@Autowired
	private ConcesionarioDAO concesionarioDAO;

	/*Create*/
	@GetMapping("/concesionario/agregar")
	public ModelAndView addConcesionario() {
		ModelAndView model= new ModelAndView();
		model.addObject("concesionario" , new Concesionario());
		model.setViewName("agregarConcesionario");
		return model;
	}
	
	@PostMapping("/concesionario/post")
	public String recojerDatos(@ModelAttribute Concesionario concesionario) {
		concesionarioDAO.save(concesionario);
		return "redirect:/concesionario/lista";
	}
	
	
	
	/*Read*/
	@GetMapping("/concesionario/lista")
	public ModelAndView mostrarDatos() {
		ModelAndView model = new ModelAndView();
		List <Concesionario> listaConcesionario = (List<Concesionario>) concesionarioDAO.findAll();
		model.addObject("listaConcesionario", listaConcesionario);
		model.setViewName("listaConcesionario");
		return model;
	}
	
	
	/*Delete*/
	@GetMapping("/concesionario/borrar/{id}")
	public String borrarDatos(@PathVariable Integer id) {
		concesionarioDAO.deleteById(id);
		return "redirect:/concesionario/lista";
	}
	
	
	/*Update*/
	@GetMapping("/concesionario/editar/{id}")
	public ModelAndView editarDatos(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Optional<Concesionario> conce = concesionarioDAO.findById(id);
		Concesionario concesionario = new Concesionario();
		concesionario = conce.get();
		model.addObject("concesionario", concesionario);
		model.setViewName("editarConcesionario");
		return model;
	}
	
}
