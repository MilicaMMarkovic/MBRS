package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.model.Trka;
import com.example.demo.service.TrkaService;
import com.example.demo.support.TrkaDTOToTrka;
import com.example.demo.support.TrkaToTrkaDTO;
import com.example.demo.web.dto.TrkaDTO;

import javax.validation.Valid;

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

@RestController
@RequestMapping(value = "/api/trkaList")
public class ApiTrkaController {

	@Autowired
	private TrkaService trkaService;

	@Autowired
	private TrkaToTrkaDTO toDTO;

	@Autowired
	private TrkaDTOToTrka toTrka;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TrkaDTO>> getTrkaList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page) {

		List<Trka> trkaList;
		int totalItems = 0;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		Page<Trka> trkaListPage;
		
		if(page != null) {
			trkaListPage = trkaService.findAll(page);
			totalItems = trkaService.findAll().size();
			httpHeaders.add("total-items", "" + totalItems);
			trkaList = trkaListPage.getContent();
		}
		else {
			trkaList = trkaService.findAll();
		}
	
		return new ResponseEntity<>(toDTO.convert(trkaList), httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByTakmicenje/{id}", method = RequestMethod.GET)
		ResponseEntity<List<TrkaDTO>> getTrkaListByTakmicenje(@PathVariable Long id) {

		List<Trka> trkaList;
		
		trkaList = trkaService.findByTakmicenjeId(id);
			
		return new ResponseEntity<>(toDTO.convert(trkaList), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TrkaDTO> getTrka(@PathVariable Long id) {
		Trka trka = trkaService.findOne(id);
		if (trka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(trka), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TrkaDTO> delete(@PathVariable Long id) {
		Trka deleted = trkaService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TrkaDTO> add(@RequestBody @Valid TrkaDTO newTrka) {

		Trka savedTrka = trkaService.save(toTrka
				.convert(newTrka));

		return new ResponseEntity<>(toDTO.convert(savedTrka), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TrkaDTO> edit(@RequestBody @Valid TrkaDTO trka,
			@PathVariable Long id) {

		if (id != trka.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Trka persisted = trkaService.save(toTrka.convert(trka));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

}
