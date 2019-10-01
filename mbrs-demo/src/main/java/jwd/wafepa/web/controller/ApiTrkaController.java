package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.service.TrkaService;
import jwd.wafepa.support.TrkaDTOToTrka;
import jwd.wafepa.support.TrkaToTrkaDTO;
import jwd.wafepa.web.dto.TakmicenjeDTO;
import jwd.wafepa.web.dto.TrkaDTO;

@RestController
@RequestMapping(value = "/api/trkas")
public class ApiTrkaController {

	@Autowired
	TrkaService trkaService;
	@Autowired
	TrkaDTOToTrka dtoTotrka;
	@Autowired
	TrkaToTrkaDTO trkaToDto;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TrkaDTO>> getTrkas() {
		List<Takmicenje> taks = takmicenjeService.findAll();
		return new ResponseEntity<>(takToDto.convert(taks), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TakmicenjeDTO> getTakmicenje(@PathVariable Long id) {
		Takmicenje tak = takmicenjeService.findOne(id);
		if (tak == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(takToDto.convert(tak), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TakmicenjeDTO> delete(@PathVariable Long id) {
		Takmicenje toDelete = takmicenjeService.delete(id);
		if (toDelete == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(takToDto.convert(toDelete), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TakmicenjeDTO> add(@RequestBody TakmicenjeDTO newTak){
		
		Takmicenje savedTak = takmicenjeService.save(dtoToTak.convert(newTak));
		return new ResponseEntity<>(takToDto.convert(savedTak), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<TakmicenjeDTO> edit(@RequestBody TakmicenjeDTO tak, @PathVariable Long id){
		if(!id.equals(tak.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Takmicenje persisted=takmicenjeService.save(dtoToTak.convert(tak));
		return new ResponseEntity<>(takToDto.convert(persisted), HttpStatus.OK);
	}
}
