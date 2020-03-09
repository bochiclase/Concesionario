package com.concesionario.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concesionario.negocio.Concesionario;

@Repository
public interface ConcesionarioDAO extends CrudRepository <Concesionario, Integer> {
	
}


