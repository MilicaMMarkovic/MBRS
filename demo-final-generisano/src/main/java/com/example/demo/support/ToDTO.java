package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.;
import com.example.demo.web.dto.DTO;


@Component
public class ToDTO implements Converter<, DTO> {


	@Override
	public DTO convert( ) {
		DTO dto = new DTO();
		
		dto.setId(.getId());
		return dto;
	}
	
	public List<DTO> convert(List<> List){
		List<DTO> DTOList = new ArrayList<>();
		
		for(  : List){
			DTOList.add(convert());
		}
		
		return DTOList;
	}
}
