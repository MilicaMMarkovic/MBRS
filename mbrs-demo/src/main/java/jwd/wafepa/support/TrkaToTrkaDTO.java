package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Trka;
import jwd.wafepa.web.dto.TrkaDTO;

@Component
public class TrkaToTrkaDTO implements Converter<Trka, TrkaDTO> {

	@Override
	public TrkaDTO convert(Trka t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return null;
		}

		TrkaDTO dto = new TrkaDTO();

		dto.setId(t.getId());
		dto.setCena(t.getCena());
		dto.setDuzinaKm(t.getDuzina_km());
		dto.setNaziv(t.getNaziv());
		dto.setNazivTakmicenja(t.getTakmicenje().getNaziv());
		dto.setTakmicenjeId(t.getTakmicenje().getId());

		return dto;
	}

	public List<TrkaDTO> convert(List<Trka> ts) {
		List<TrkaDTO> ret = new ArrayList<>();

		for (Trka t : ts) {
			ret.add(convert(t));
		}

		return ret;
	}

}
