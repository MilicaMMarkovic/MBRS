package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.model.Takmicenje;
import com.example.demo.service.TakmicenjeService;
import com.example.demo.support.TakmicenjeDTOToTakmicenje;
import com.example.demo.support.TakmicenjeToTakmicenjeDTO;
import com.example.demo.web.dto.TakmicenjeDTO;

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
@RequestMapping(value = "/api/takmicenjeList")
public class ApiTakmicenjeController {

	@Autowired
	private TakmicenjeService takmicenjeService;

	@Autowired
	private TakmicenjeToTakmicenjeDTO toDTO;

	@Autowired
	private TakmicenjeDTOToTakmicenje toTakmicenje;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TakmicenjeDTO>> getTakmicenjeList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page) {

		List<Takmicenje> takmicenjeList;
		int totalItems = 0;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		Page<Takmicenje> takmicenjeListPage;
		
		if(page != null) {
			takmicenjeListPage = takmicenjeService.findAll(page);
			totalItems = takmicenjeService.findAll().size();
			httpHeaders.add("total-items", "" + totalItems);
			takmicenjeList = takmicenjeListPage.getContent();
		}
		else {
			takmicenjeList = takmicenjeService.findAll();
		}
	
		return new ResponseEntity<>(toDTO.convert(takmicenjeList), httpHeaders, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TakmicenjeDTO> getTakmicenje(@PathVariable Long id) {
		Takmicenje takmicenje = takmicenjeService.findOne(id);
		if (takmicenje == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(takmicenje), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TakmicenjeDTO> delete(@PathVariable Long id) {
		Takmicenje deleted = takmicenjeService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TakmicenjeDTO> add(@RequestBody @Valid TakmicenjeDTO newTakmicenje) {

		Takmicenje savedTakmicenje = takmicenjeService.save(toTakmicenje
				.convert(newTakmicenje));

		return new ResponseEntity<>(toDTO.convert(savedTakmicenje), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TakmicenjeDTO> edit(@RequestBody @Valid TakmicenjeDTO takmicenje,
			@PathVariable Long id) {

		if (id != takmicenje.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Takmicenje persisted = takmicenjeService.save(toTakmicenje.convert(takmicenje));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

}
