package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicar;
import jwd.wafepa.model.Trka;
import jwd.wafepa.service.TakmicarService;
import jwd.wafepa.service.TrkaService;
import jwd.wafepa.web.dto.TakmicarDTO;

@Component
public class TakmicarDTOToTakmicar implements Converter<TakmicarDTO, Takmicar> {

	@Autowired
	TakmicarService takmicarService;

	@Autowired
	TrkaService trkaService;

	@Override
	public Takmicar convert(TakmicarDTO dto) {
		// TODO Auto-generated method stub
		Trka trka = trkaService.findOne(dto.getTrkaId());
		if (trka != null) {
			Takmicar takmicar = null;
			if (dto.getId() != null) {
				takmicar = takmicarService.findOne(dto.getId());
			} else {
				takmicar = new Takmicar();
			}
			takmicar.setId(dto.getId());
			takmicar.setImeIPrezime(dto.getImeIPrezime());
			takmicar.setJmbg(dto.getJmbg());
			takmicar.setKontakt(dto.getKontakt());
			takmicar.setPol(dto.getPol());
			takmicar.setTrka(trka);
			return takmicar;
		} else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}

	}

	public List<Takmicar> convert(List<TakmicarDTO> dtos) {
		List<Takmicar> ts = new ArrayList<>();

		for (TakmicarDTO dto : dtos) {
			ts.add(convert(dto));
		}

		return ts;
	}

}
