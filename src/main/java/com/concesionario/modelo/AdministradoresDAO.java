package com.concesionario.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concesionario.negocio.Administradores;

@Repository
public interface AdministradoresDAO extends CrudRepository<Administradores,Integer>{

}
