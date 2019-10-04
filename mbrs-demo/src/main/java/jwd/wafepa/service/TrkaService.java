package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Trka;

public interface TrkaService {

	Trka findOne(Long id);

	Page<Trka> findAll(int pageNum);

	Trka save(Trka trka);

	void delete(Long id);

	List<Trka> findByDuzinaKm(double duzina_km);
}
