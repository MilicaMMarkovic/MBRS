package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.repository.TakmicenjeRepository;
import jwd.wafepa.service.TakmicenjeService;

@Service
@Transactional
public class JpaTakmicenjeService implements TakmicenjeService {
	
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;

	@Override
	public Takmicenje findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findOne(id);
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		// TODO Auto-generated method stub
		Takmicenje takmicenje=takmicenjeRepository.findOne(id);
		if(takmicenje==null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		takmicenjeRepository.delete(takmicenje);
		return takmicenje;
	}

	@Override
	public Page<Takmicenje> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findAll(new PageRequest(pageNum, 5));
	}

	

}
