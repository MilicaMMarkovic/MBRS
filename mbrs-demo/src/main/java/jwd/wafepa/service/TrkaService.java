package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Trka;

public interface TrkaService {

	Trka findOne(Long id);

	List<Trka> findAll();

	Trka save(Trka trka);

	void delete(Long id);

	List<Trka> findByDuzinaKm(double duzina_km);
}
