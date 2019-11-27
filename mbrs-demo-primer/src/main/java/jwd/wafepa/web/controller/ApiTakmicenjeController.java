package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.support.TakmicenjeDTOToTakmicenje;
import jwd.wafepa.support.TakmicenjeToTakmicenjeDTO;
import jwd.wafepa.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/takmicenjes")
public class ApiTakmicenjeController {

	@Autowired
	private TakmicenjeService takmicenjeService;

	@Autowired
	private TakmicenjeToTakmicenjeDTO takToDto;
	@Autowired
	private TakmicenjeDTOToTakmicenje dtoToTak;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TakmicenjeDTO>> getTakmicenjes(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {
		Page<Takmicenje> taks = takmicenjeService.findAll(pageNum);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(taks.getTotalPages()));
		return new ResponseEntity<>(takToDto.convert(taks.getContent()), headers, HttpStatus.OK);
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

