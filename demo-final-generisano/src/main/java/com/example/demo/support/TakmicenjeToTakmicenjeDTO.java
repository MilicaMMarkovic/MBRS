package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Takmicenje;
import com.example.demo.web.dto.TakmicenjeDTO;


@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO> {


	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO dto = new TakmicenjeDTO();
		
		dto.setId(takmicenje.getId());
		dto.setNaziv(takmicenje.getNaziv());
		dto.setDatum(takmicenje.getDatum());
		dto.setOrganizator(takmicenje.getOrganizator());
		dto.setKontakt(takmicenje.getKontakt());
		return dto;
	}
	
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenjeList){
		List<TakmicenjeDTO> takmicenjeDTOList = new ArrayList<>();
		
		for(Takmicenje takmicenje : takmicenjeList){
			takmicenjeDTOList.add(convert(takmicenje));
		}
		
		return takmicenjeDTOList;
	}
}
