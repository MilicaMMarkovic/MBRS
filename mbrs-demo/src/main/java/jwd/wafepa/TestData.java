package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.repository.TakmicenjeRepository;
import jwd.wafepa.repository.TrkaRepository;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.TrkaService;

@Component
public class TestData {

//	@Autowired
//	private ActivityService activityService;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private RecordService recordService;

	@Autowired
	TakmicenjeRepository takRepo;
	@Autowired
	TrkaRepository trkaRepo;
	@Autowired
	TrkaService trkaService;
	@Autowired
	TakmicenjeService takmicenjeService;

	@PostConstruct
	public void init() {

		Takmicenje tak1 = new Takmicenje();
		tak1.setId(1L);
		tak1.setDatum("t1");
		tak1.setKontakt("t1");
		tak1.setNaziv("t1");
		tak1.setOrganizator("t1");
		takmicenjeService.save(tak1);
		takRepo.save(tak1);

		Takmicenje tak2 = new Takmicenje();
		tak2.setId(2L);
		tak1.setDatum("t2");
		tak1.setKontakt("t2");
		tak1.setNaziv("t2");
		tak1.setOrganizator("t2");
		takmicenjeService.save(tak2);
		takRepo.save(tak2);


//		Trka trk1 = new Trka();
//		trk1.setCena(1000);
//		trk1.setDuzina_km(10);
//		trk1.setNaziv("trka1");
//		trk1.setTakmicenje(tak1);

//		tak1.getTrke().add(trk1);
//		trkaService.save(trk1);
//		takmicenjeService.save(tak1);
		// takRepo.save(tak1);
	}
}
