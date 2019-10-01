package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Takmicenje;

public interface TakmicenjeService {

	Takmicenje findOne(Long id);

	List<Takmicenje> findAll();

	Takmicenje save(Takmicenje takmicenje);

	Takmicenje delete(Long id);
	
	List<Takmicenje> findByNaziv(String naziv);
}
