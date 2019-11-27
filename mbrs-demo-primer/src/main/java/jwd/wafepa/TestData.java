package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicar;
import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.model.Trka;
import jwd.wafepa.repository.TakmicenjeRepository;
import jwd.wafepa.repository.TrkaRepository;
import jwd.wafepa.service.TakmicarService;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.TrkaService;

@Component
public class TestData {

	@Autowired
	TakmicenjeRepository takRepo;
	@Autowired
	TrkaRepository trkaRepo;
	@Autowired
	TrkaService trkaService;
	@Autowired
	TakmicenjeService takmicenjeService;
	@Autowired
	TakmicarService takmicarService;

	@PostConstruct
	public void init() {

		Takmicenje tak1 = new Takmicenje("10/2/2019", "tak1", "tak1", "tak1");
		takmicenjeService.save(tak1);

		Takmicenje tak2 = new Takmicenje("10/4/2019", "tak2", "tak2", "tak2");
		takmicenjeService.save(tak2);

		Trka trka1 = new Trka(tak1, 10.5, "frtalj maraton", 1000);
		tak1.addTrka(trka1);
		trkaService.save(trka1);
		takmicenjeService.save(tak1);

		Trka trka2 = new Trka(tak1, 21.1, "polumaraton", 2000);
		tak1.addTrka(trka2);
		trkaService.save(trka2);
		takmicenjeService.save(tak1);

		Trka trka3 = new Trka(tak2, 42.2, "maraton", 4000);
		tak1.addTrka(trka3);
		trkaService.save(trka3);
		takmicenjeService.save(tak2);

		Takmicar t1=new Takmicar("Milica Markovic", "2109994805052", "zenski", "mm@example.com", trka1);
		trka1.addTakmicar(t1);
		takmicarService.save(t1);
		trkaService.save(trka1);
		
		Takmicar t2=new Takmicar("Mica Markovic", "2109994805152", "zenski", "mmm@example.com", trka1);
		trka1.addTakmicar(t2);
		takmicarService.save(t2);
		trkaService.save(trka1);
		
		Takmicar t3=new Takmicar("Pera Peric", "1234567890123", "muski", "ppp@example.com", trka2);
		trka2.addTakmicar(t3);
		takmicarService.save(t3);
		trkaService.save(trka2);
	}
}
