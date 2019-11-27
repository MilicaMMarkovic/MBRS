package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Trka;
import com.example.demo.repository.TrkaRepository;
import com.example.demo.service.TrkaService;


@Service
@Transactional
public class TrkaServiceImpl implements TrkaService {

	@Autowired
	private TrkaRepository trkaRepository;
	
	@Override
	public Trka findOne(Long id) {
		return trkaRepository.findOne(id);
	}

	@Override
	public List<Trka> findAll() {
		return trkaRepository.findAll();
	}
		
	@Override
	public Page<Trka> findAll(int page) {
		return trkaRepository.findAll(new PageRequest(page, 12));
	}

	@Override
	public Trka save(Trka trka) {
		return trkaRepository.save(trka);
	}
	
	public Trka remove(Long id) {
		Trka trka = trkaRepository.findOne(id);
		if(trka == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant Trka");
		}
		trkaRepository.delete(trka);
		return trka;
	}
	
	public List<Trka> findByNaziv(String naziv) {
		return trkaRepository.findByNaziv(naziv);
	}
	
	public List<Trka> findByTakmicenjeId(Long id) {
		return trkaRepository.findByTakmicenjeId(id);
	}
	
	
}
