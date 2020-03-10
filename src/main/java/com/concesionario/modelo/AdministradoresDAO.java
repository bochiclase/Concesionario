package com.concesionario.modelo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concesionario.negocio.Administradores;

@Repository
public interface AdministradoresDAO extends CrudRepository<Administradores,String>{

	@Transactional @Query(value="Select * from administradores where telefono=:telefono",nativeQuery=true)
	List<Administradores> buscarPorTelefono(@Param("telefono") String tel);
	
	Optional<Administradores> findById(String username);

	//Optional<Administradores> findById(String username);



}
