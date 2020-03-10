package com.concesionario.seguridad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.concesionario.modelo.AdministradoresDAO;
import com.concesionario.negocio.Administradores;

@Service
public class Autenticacion implements UserDetailsService 

{
	@Autowired
	private AdministradoresDAO adminDAO;
		
	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Optional<Administradores> user = adminDAO.findById(username);
		
		if(user.isPresent()) {
			
			return user.get(); 
		}
		else throw new  UsernameNotFoundException(""+username);
	}
}
