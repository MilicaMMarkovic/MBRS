package com.example.demo.web.controller;

import java.util.List;

import com.example.demo.model.;
import com.example.demo.service.Service;
import com.example.demo.support.DTOTo;
import com.example.demo.support.ToDTO;
import com.example.demo.web.dto.DTO;

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
@RequestMapping(value = "/api/List")
public class ApiController {

	@Autowired
	private Service Service;

	@Autowired
	private ToDTO toDTO;

	@Autowired
	private DTOTo to;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<DTO>> getList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page) {

		List<> List;
		int totalItems = 0;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		Page<> ListPage;
		
		if(page != null) {
			ListPage = Service.findAll(page);
			totalItems = Service.findAll().size();
			httpHeaders.add("total-items", "" + totalItems);
			List = ListPage.getContent();
		}
		else {
			List = Service.findAll();
		}
	
		return new ResponseEntity<>(toDTO.convert(List), httpHeaders, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<DTO> get(@PathVariable Long id) {
		  = Service.findOne(id);
		if ( == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<DTO> delete(@PathVariable Long id) {
		 deleted = Service.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DTO> add(@RequestBody @Valid DTO new) {

		 saved = Service.save(to
				.convert(new));

		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<DTO> edit(@RequestBody @Valid DTO ,
			@PathVariable Long id) {

		if (id != .getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		 persisted = Service.save(to.convert());

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

}
