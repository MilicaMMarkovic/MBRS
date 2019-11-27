package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.model.Trka;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.TrkaService;
import jwd.wafepa.web.dto.TrkaDTO;

@Component
public class TrkaDTOToTrka implements Converter<TrkaDTO, Trka> {

	@Autowired
	TrkaService trkaService;

	@Autowired
	TakmicenjeService takmicenjeService;

	@Override
	public Trka convert(TrkaDTO dto) {
		// TODO Auto-generated method stub
		Trka t = null;

		if (dto.getId() != null) {
			t = trkaService.findOne(dto.getId());

			if (t == null) {
				throw new IllegalStateException("Tried to " + "modify a non-existant entity");
			}
		} else {
			t = new Trka();
		}
		t.setCena(dto.getCena());
		t.setDuzina_km(dto.getDuzinaKm());
		t.setNaziv(dto.getNaziv());

		Takmicenje tak = takmicenjeService.findOne(dto.getTakmicenjeId());
		if (tak != null) {
			t.setTakmicenje(tak);
		}

		return t;
	}

	public List<Trka> convert(List<TrkaDTO> dtos) {
		List<Trka> ts = new ArrayList<>();

		for (TrkaDTO dto : dtos) {
			ts.add(convert(dto));
		}

		return ts;
	}

}
