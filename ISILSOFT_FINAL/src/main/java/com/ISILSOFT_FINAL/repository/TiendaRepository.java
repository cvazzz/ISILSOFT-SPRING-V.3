package com.ISILSOFT_FINAL.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISILSOFT_FINAL.entity.Tienda;
@Repository
public interface TiendaRepository extends JpaRepository<Tienda,Integer> {
	List<Tienda>findByDistrito(String distrito);
	List<Tienda>findAll();
	

}
