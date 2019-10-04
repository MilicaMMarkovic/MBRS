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

import jwd.wafepa.model.Trka;
import jwd.wafepa.service.TrkaService;
import jwd.wafepa.support.TrkaDTOToTrka;
import jwd.wafepa.support.TrkaToTrkaDTO;
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
	ResponseEntity<List<TrkaDTO>> getTrkas(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {
		Page<Trka> taks = trkaService.findAll(pageNum);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(taks.getTotalPages()));
		return new ResponseEntity<>(trkaToDto.convert(taks.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TrkaDTO> getTrka(@PathVariable Long id) {
		Trka trka = trkaService.findOne(id);
		if (trka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trkaToDto.convert(trka), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TrkaDTO> delete(@PathVariable Long id) {
		trkaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TrkaDTO> add(@RequestBody TrkaDTO newTrka) {

		Trka savedTak = trkaService.save(dtoTotrka.convert(newTrka));
		return new ResponseEntity<>(trkaToDto.convert(savedTak), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TrkaDTO> edit(@RequestBody TrkaDTO trka, @PathVariable Long id) {
		if (!id.equals(trka.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Trka persisted = trkaService.save(dtoTotrka.convert(trka));
		return new ResponseEntity<>(trkaToDto.convert(persisted), HttpStatus.OK);
	}
}
