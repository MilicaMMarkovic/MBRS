package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Takmicar;

public interface TakmicarService {

	Takmicar findOne(Long id);

	Page<Takmicar> findAll(int pageNum);

	Takmicar save(Takmicar takmicar);

	Takmicar delete(Long id);
	
}
