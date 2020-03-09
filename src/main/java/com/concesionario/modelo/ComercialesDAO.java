package com.concesionario.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concesionario.negocio.Comerciales;

@Repository
public interface ComercialesDAO extends CrudRepository <Comerciales,Integer> {

}
