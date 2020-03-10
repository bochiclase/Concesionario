package com.concesionario.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol {
	
	@Id
	private String nombre;

	@OneToMany(mappedBy="rol", fetch = FetchType.EAGER)
	private List <Administradores> administradores;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Administradores> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administradores> administradores) {
		this.administradores = administradores;
	}

	@Override
	public String toString() {
		return nombre ;
	}
	
	
	
}
