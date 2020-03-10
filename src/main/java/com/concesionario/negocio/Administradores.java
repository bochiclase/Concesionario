package com.concesionario.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Administradores implements UserDetails{
	
	@Id
	private String nombre;
	@Column
	private String telefono;
	@Column
	private String pass;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List <Concesionario> concesionarios;

	@ManyToOne
	private Rol rol;
	
	

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



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	@Override
	public String toString() {
		return  nombre;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre()));
	    	    
	    return grantedAuthorities;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nombre;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pass;
	}



}