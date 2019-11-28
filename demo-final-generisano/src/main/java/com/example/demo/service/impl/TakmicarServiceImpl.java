package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Takmicar;
import com.example.demo.repository.TakmicarRepository;
import com.example.demo.service.TakmicarService;


@Service
@Transactional
public class TakmicarServiceImpl implements TakmicarService {

	@Autowired
	private TakmicarRepository takmicarRepository;
	
	@Override
	public Takmicar findOne(Long id) {
		return takmicarRepository.findOne(id);
	}

	@Override
	public List<Takmicar> findAll() {
		return takmicarRepository.findAll();
	}
		
	@Override
	public Page<Takmicar> findAll(int page) {
		return takmicarRepository.findAll(new PageRequest(page, 12));
	}

	@Override
	public Takmicar save(Takmicar takmicar) {
		return takmicarRepository.save(takmicar);
	}
	
	public Takmicar remove(Long id) {
		Takmicar takmicar = takmicarRepository.findOne(id);
		if(takmicar == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant Takmicar");
		}
		takmicarRepository.delete(takmicar);
		return takmicar;
	}
	
	public List<Takmicar> findByTrkaId(Long id) {
		return takmicarRepository.findByTrkaId(id);
	}
	
	
}
