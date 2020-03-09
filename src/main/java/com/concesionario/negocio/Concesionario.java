package com.concesionario.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity

public class Concesionario {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String marca;
	@Column
	private String localidad;
	
	@OneToMany(mappedBy="concesionario")
	private List <Comerciales> comerciales;
	
	@ManyToMany(mappedBy="concesionarios")
	private List <Administradores> administradores;

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Comerciales> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comerciales> comerciales) {
		this.comerciales = comerciales;
	}

	@Override
	public String toString() {
		return  nombre ;
	}
	

	
	
}
