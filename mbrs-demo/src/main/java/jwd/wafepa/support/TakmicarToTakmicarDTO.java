package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicar;
import jwd.wafepa.web.dto.TakmicarDTO;

@Component
public class TakmicarToTakmicarDTO implements Converter<Takmicar, TakmicarDTO> {

	@Override
	public TakmicarDTO convert(Takmicar t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return null;
		}

		TakmicarDTO dto = new TakmicarDTO();

		dto.setId(t.getId());
		dto.setImeIPrezime(t.getImeIPrezime());
		dto.setJmbg(t.getJmbg());
		dto.setKontakt(t.getKontakt());
		dto.setNazivTrke(t.getTrka().getNaziv());
		dto.setTrkaId(t.getTrka().getId());

		return dto;
	}

	public List<TakmicarDTO> convert(List<Takmicar> ts) {
		List<TakmicarDTO> ret = new ArrayList<>();

		for (Takmicar t : ts) {
			ret.add(convert(t));
		}

		return ret;
	}

}
