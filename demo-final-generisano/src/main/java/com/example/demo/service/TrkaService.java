package com.example.demo.service;

import com.example.demo.model.Trka;
import java.util.List;

public interface TrkaService extends CrudService<Trka> {
	
	List<Trka> findByNaziv(String naziv);
	
	List<Trka> findByTakmicenjeId(Long id);
	
}
