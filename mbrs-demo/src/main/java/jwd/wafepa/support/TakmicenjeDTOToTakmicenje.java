package jwd.wafepa.support;

import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.web.dto.TakmicenjeDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class TakmicenjeDTOToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje> {

	@Autowired
	TakmicenjeService takmicenjeService;

	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		// TODO Auto-generated method stub
		Takmicenje t = null;

		if (dto.getId() != null) {
			t = takmicenjeService.findOne(dto.getId());

			if (t == null) {
				throw new IllegalStateException("Tried to " + "modify a non-existant entity");
			}

		} else {
			t = new Takmicenje();
		}
		t.setDatum(dto.getDatum());
		t.setKontakt(dto.getKontakt());
		t.setNaziv(dto.getNaziv());
		t.setOrganizator(dto.getOrganizator());

		return t;
	}

	public List<Takmicenje> convert(List<TakmicenjeDTO> dtoTs) {
		List<Takmicenje> ts = new ArrayList<>();

		for (TakmicenjeDTO dto : dtoTs) {
			ts.add(convert(dto));
		}

		return ts;
	}

}
