package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Trka;
import com.example.demo.service.TrkaService;
import com.example.demo.web.dto.TrkaDTO;

import com.example.demo.support.TakmicenjeDTOToTakmicenje;

@Component
public class TrkaDTOToTrka
	implements Converter<TrkaDTO, Trka> {
	
	@Autowired
	private TakmicenjeDTOToTakmicenje toTakmicenje;
	
	@Autowired
	TrkaService trkaService;

	@Override
	public Trka convert(TrkaDTO dto) {
		Trka trka = new Trka();
		
		if(dto.getId()!=null){
			trka = trkaService.findOne(dto.getId());
			
			if(trka == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant trka");
			}
		}
		
		trka.setId(dto.getId());
		
	    trka.setNaziv(dto.getNaziv());
	    trka.setCena(dto.getCena());
	    trka.setDuzinaKm(dto.getDuzinaKm());
		trka.setTakmicenje(toTakmicenje.convert(dto.getTakmicenje()));
		
		
		return trka;
	}
	
	public List<Trka> convert (List<TrkaDTO> trkaDTOList){
		List<Trka> trkaList = new ArrayList<>();
		
		for(TrkaDTO dto : trkaDTOList){
			trkaList.add(convert(dto));
		}
		
		return trkaList;
	}

}