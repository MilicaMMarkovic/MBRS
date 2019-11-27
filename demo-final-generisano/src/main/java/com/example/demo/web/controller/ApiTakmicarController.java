package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.model.Takmicar;
import com.example.demo.service.TakmicarService;
import com.example.demo.support.TakmicarDTOToTakmicar;
import com.example.demo.support.TakmicarToTakmicarDTO;
import com.example.demo.web.dto.TakmicarDTO;

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
@RequestMapping(value = "/api/takmicarList")
public class ApiTakmicarController {

	@Autowired
	private TakmicarService takmicarService;

	@Autowired
	private TakmicarToTakmicarDTO toDTO;

	@Autowired
	private TakmicarDTOToTakmicar toTakmicar;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TakmicarDTO>> getTakmicarList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page) {

		List<Takmicar> takmicarList;
		int totalItems = 0;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		Page<Takmicar> takmicarListPage;
		
		if(page != null) {
			takmicarListPage = takmicarService.findAll(page);
			totalItems = takmicarService.findAll().size();
			httpHeaders.add("total-items", "" + totalItems);
			takmicarList = takmicarListPage.getContent();
		}
		else {
			takmicarList = takmicarService.findAll();
		}
	
		return new ResponseEntity<>(toDTO.convert(takmicarList), httpHeaders, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TakmicarDTO> getTakmicar(@PathVariable Long id) {
		Takmicar takmicar = takmicarService.findOne(id);
		if (takmicar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(takmicar), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TakmicarDTO> delete(@PathVariable Long id) {
		Takmicar deleted = takmicarService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TakmicarDTO> add(@RequestBody @Valid TakmicarDTO newTakmicar) {

		Takmicar savedTakmicar = takmicarService.save(toTakmicar
				.convert(newTakmicar));

		return new ResponseEntity<>(toDTO.convert(savedTakmicar), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TakmicarDTO> edit(@RequestBody @Valid TakmicarDTO takmicar,
			@PathVariable Long id) {

		if (id != takmicar.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Takmicar persisted = takmicarService.save(toTakmicar.convert(takmicar));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

}
