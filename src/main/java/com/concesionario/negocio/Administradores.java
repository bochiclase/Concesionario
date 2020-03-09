package com.concesionario.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Administradores {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String telefono;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List <Concesionario> concesionarios;

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public List<Concesionario> getConcesionarios() {
		return concesionarios;
	}



	public void setConcesionarios(List<Concesionario> concesionarios) {
		this.concesionarios = concesionarios;
	}



	@Override
	public String toString() {
		return  nombre;
	}
	
	
}
