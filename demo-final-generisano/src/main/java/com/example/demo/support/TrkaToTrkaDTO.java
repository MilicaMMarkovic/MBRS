package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Trka;
import com.example.demo.web.dto.TrkaDTO;

import com.example.demo.support.TakmicenjeToTakmicenjeDTO;

@Component
public class TrkaToTrkaDTO implements Converter<Trka, TrkaDTO> {

	@Autowired
	private TakmicenjeToTakmicenjeDTO toTakmicenjeDTO;

	@Override
	public TrkaDTO convert(Trka trka) {
		TrkaDTO dto = new TrkaDTO();
		
		dto.setId(trka.getId());
		dto.setNaziv(trka.getNaziv());
		dto.setCena(trka.getCena());
		dto.setDuzinaKm(trka.getDuzinaKm());
		dto.setTakmicenje(toTakmicenjeDTO.convert(trka.getTakmicenje()));
		return dto;
	}
	
	public List<TrkaDTO> convert(List<Trka> trkaList){
		List<TrkaDTO> trkaDTOList = new ArrayList<>();
		
		for(Trka trka : trkaList){
			trkaDTOList.add(convert(trka));
		}
		
		return trkaDTOList;
	}
}
