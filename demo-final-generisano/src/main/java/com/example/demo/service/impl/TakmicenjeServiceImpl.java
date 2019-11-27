package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Takmicenje;
import com.example.demo.repository.TakmicenjeRepository;
import com.example.demo.service.TakmicenjeService;


@Service
@Transactional
public class TakmicenjeServiceImpl implements TakmicenjeService {

	@Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	@Override
	public Takmicenje findOne(Long id) {
		return takmicenjeRepository.findOne(id);
	}

	@Override
	public List<Takmicenje> findAll() {
		return takmicenjeRepository.findAll();
	}
		
	@Override
	public Page<Takmicenje> findAll(int page) {
		return takmicenjeRepository.findAll(new PageRequest(page, 12));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}
	
	public Takmicenje remove(Long id) {
		Takmicenje takmicenje = takmicenjeRepository.findOne(id);
		if(takmicenje == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant Takmicenje");
		}
		takmicenjeRepository.delete(takmicenje);
		return takmicenje;
	}
	
	
}
