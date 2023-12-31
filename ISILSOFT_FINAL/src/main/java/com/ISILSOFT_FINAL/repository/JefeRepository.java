package com.ISILSOFT_FINAL.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISILSOFT_FINAL.entity.JefeTienda;
@Repository
public interface JefeRepository extends JpaRepository<JefeTienda,Integer> {
	List<JefeTienda>findAll();
}
