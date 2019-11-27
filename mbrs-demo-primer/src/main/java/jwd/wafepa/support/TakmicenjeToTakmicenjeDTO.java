package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO> {

	@Override
	public TakmicenjeDTO convert(Takmicenje t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return null;
		}

		TakmicenjeDTO dto = new TakmicenjeDTO();

		dto.setId(t.getId());
		dto.setDatum(t.getDatum());
		dto.setKontakt(t.getKontakt());
		dto.setNaziv(t.getNaziv());
		dto.setOrganizator(t.getOrganizator());

		return dto;
	}

	public List<TakmicenjeDTO> convert(List<Takmicenje> ts) {
		List<TakmicenjeDTO> ret = new ArrayList<>();

		for (Takmicenje a : ts) {
			ret.add(convert(a));
		}

		return ret;
	}
}
