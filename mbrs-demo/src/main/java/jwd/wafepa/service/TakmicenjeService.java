package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Takmicenje;

public interface TakmicenjeService {

	Takmicenje findOne(Long id);

	Page<Takmicenje> findAll(int pageNum);

	Takmicenje save(Takmicenje takmicenje);

	Takmicenje delete(Long id);
	
	List<Takmicenje> findByNaziv(String naziv);
}
