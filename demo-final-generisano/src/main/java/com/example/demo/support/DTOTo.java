package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.;
import com.example.demo.service.Service;
import com.example.demo.web.dto.DTO;


@Component
public class DTOTo
	implements Converter<DTO, > {
	
	
	@Autowired
	Service Service;

	@Override
	public  convert(DTO dto) {
		  = new ();
		
		if(dto.getId()!=null){
			 = Service.findOne(dto.getId());
			
			if( == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant ");
			}
		}
		
		.setId(dto.getId());
		
		
		
		return ;
	}
	
	public List<> convert (List<DTO> DTOList){
		List<> List = new ArrayList<>();
		
		for(DTO dto : DTOList){
			List.add(convert(dto));
		}
		
		return List;
	}

}