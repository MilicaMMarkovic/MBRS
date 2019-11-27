package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.;
import com.example.demo.repository.Repository;
import com.example.demo.service.Service;


@Service
@Transactional
public class ServiceImpl implements Service {

	@Autowired
	private Repository Repository;
	
	@Override
	public  findOne(Long id) {
		return Repository.findOne(id);
	}

	@Override
	public List<> findAll() {
		return Repository.findAll();
	}
		
	@Override
	public Page<> findAll(int page) {
		return Repository.findAll(new PageRequest(page, 12));
	}

	@Override
	public  save( ) {
		return Repository.save();
	}
	
	public  remove(Long id) {
		  = Repository.findOne(id);
		if( == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant ");
		}
		Repository.delete();
		return ;
	}
	
	
}
