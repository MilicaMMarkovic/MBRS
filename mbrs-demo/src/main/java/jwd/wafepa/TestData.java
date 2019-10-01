package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Record;
import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.model.Trka;
import jwd.wafepa.model.User;
import jwd.wafepa.repository.TakmicenjeRepository;
import jwd.wafepa.repository.TrkaRepository;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.RecordService;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.UserService;

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
//	
//	@Autowired
//	private TakmicenjeService takmicenjeService;
	
	@Autowired
	TakmicenjeRepository takRepo;
	@Autowired
	TrkaRepository trkaRepo;
	
	@PostConstruct
	public void init() {
		
		Takmicenje tak1=new Takmicenje();
		tak1.setDatum("t1");
		tak1.setKontakt("t1");
		tak1.setNaziv("t1");
		tak1.setOrganizator("t1");
		takRepo.save(tak1);
		
		Takmicenje tak2=new Takmicenje();
		tak1.setDatum("t2");
		tak1.setKontakt("t2");
		tak1.setNaziv("t2");
		tak1.setOrganizator("t2");
		takRepo.save(tak2);
		
		Trka trk1 = new Trka();
		trk1.setCena(1000);
		trk1.setDuzina_km(10);
		trk1.setNaziv("trka1");
		trk1.setTakmicenje(tak1);
		tak1.addTrka(trk1);
		trkaRepo.save(trk1);
		takRepo.save(tak1);
	}
}
