package com.ISILSOFT_FINAL.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ISILSOFT_FINAL.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	

	
	Usuario findBycorreo(String correo);

	
	  Usuario findByCorreoAndPassword(String correo, String password);
}
