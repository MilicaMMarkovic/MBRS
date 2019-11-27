package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Takmicar;
import com.example.demo.service.TakmicarService;
import com.example.demo.web.dto.TakmicarDTO;

import com.example.demo.support.TrkaDTOToTrka;

@Component
public class TakmicarDTOToTakmicar
	implements Converter<TakmicarDTO, Takmicar> {
	
	@Autowired
	private TrkaDTOToTrka toTrka;
	
	@Autowired
	TakmicarService takmicarService;

	@Override
	public Takmicar convert(TakmicarDTO dto) {
		Takmicar takmicar = new Takmicar();
		
		if(dto.getId()!=null){
			takmicar = takmicarService.findOne(dto.getId());
			
			if(takmicar == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant takmicar");
			}
		}
		
		takmicar.setId(dto.getId());
		
	    takmicar.setImeIPrezime(dto.getImeIPrezime());
	    takmicar.setJmbg(dto.getJmbg());
	    takmicar.setPol(dto.getPol());
	    takmicar.setKontakt(dto.getKontakt());
		takmicar.setTrka(toTrka.convert(dto.getTrka()));
		
		
		return takmicar;
	}
	
	public List<Takmicar> convert (List<TakmicarDTO> takmicarDTOList){
		List<Takmicar> takmicarList = new ArrayList<>();
		
		for(TakmicarDTO dto : takmicarDTOList){
			takmicarList.add(convert(dto));
		}
		
		return takmicarList;
	}

}