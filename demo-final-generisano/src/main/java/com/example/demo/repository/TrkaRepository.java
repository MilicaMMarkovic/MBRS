package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Trka;


@Repository
public interface TrkaRepository extends JpaRepository<Trka, Long> {

	List<Trka> findByNaziv(String naziv);
	
	List<Trka> findByTakmicenjeId(Long id);
	

}
