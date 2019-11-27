package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Trka;
import jwd.wafepa.repository.TrkaRepository;
import jwd.wafepa.service.TrkaService;

@Service
@Transactional
public class JpaTrkaService implements TrkaService {
	
	@Autowired
	private TrkaRepository trkaRepository;

	@Override
	public Trka findOne(Long id) {
		// TODO Auto-generated method stub
		return trkaRepository.findOne(id);
	}

	@Override
	public Trka save(Trka trka) {
		// TODO Auto-generated method stub
		return trkaRepository.save(trka);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		trkaRepository.delete(id);
	}

	@Override
	public Page<Trka> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return trkaRepository.findAll(new PageRequest(pageNum, 5));
	}

}
