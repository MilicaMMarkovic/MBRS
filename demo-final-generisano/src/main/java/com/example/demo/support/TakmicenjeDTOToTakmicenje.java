package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Takmicenje;
import com.example.demo.service.TakmicenjeService;
import com.example.demo.web.dto.TakmicenjeDTO;


@Component
public class TakmicenjeDTOToTakmicenje
	implements Converter<TakmicenjeDTO, Takmicenje> {
	
	
	@Autowired
	TakmicenjeService takmicenjeService;

	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		Takmicenje takmicenje = new Takmicenje();
		
		if(dto.getId()!=null){
			takmicenje = takmicenjeService.findOne(dto.getId());
			
			if(takmicenje == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant takmicenje");
			}
		}
		
		takmicenje.setId(dto.getId());
		
	    takmicenje.setNaziv(dto.getNaziv());
	    takmicenje.setDatum(dto.getDatum());
	    takmicenje.setOrganizator(dto.getOrganizator());
	    takmicenje.setKontakt(dto.getKontakt());
		
		
		return takmicenje;
	}
	
	public List<Takmicenje> convert (List<TakmicenjeDTO> takmicenjeDTOList){
		List<Takmicenje> takmicenjeList = new ArrayList<>();
		
		for(TakmicenjeDTO dto : takmicenjeDTOList){
			takmicenjeList.add(convert(dto));
		}
		
		return takmicenjeList;
	}

}