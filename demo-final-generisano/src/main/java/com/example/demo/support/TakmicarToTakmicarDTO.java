package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Takmicar;
import com.example.demo.web.dto.TakmicarDTO;

import com.example.demo.support.TrkaToTrkaDTO;

@Component
public class TakmicarToTakmicarDTO implements Converter<Takmicar, TakmicarDTO> {

	@Autowired
	private TrkaToTrkaDTO toTrkaDTO;

	@Override
	public TakmicarDTO convert(Takmicar takmicar) {
		TakmicarDTO dto = new TakmicarDTO();
		
		dto.setId(takmicar.getId());
		dto.setIme(takmicar.getIme());
		dto.setJmbg(takmicar.getJmbg());
		dto.setPol(takmicar.getPol());
		dto.setKontakt(takmicar.getKontakt());
		dto.setTrka(toTrkaDTO.convert(takmicar.getTrka()));
		dto.setPrezime(takmicar.getPrezime());
		return dto;
	}
	
	public List<TakmicarDTO> convert(List<Takmicar> takmicarList){
		List<TakmicarDTO> takmicarDTOList = new ArrayList<>();
		
		for(Takmicar takmicar : takmicarList){
			takmicarDTOList.add(convert(takmicar));
		}
		
		return takmicarDTOList;
	}
}
