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

import jwd.wafepa.model.Takmicar;
import jwd.wafepa.service.TakmicarService;
import jwd.wafepa.support.TakmicarDTOToTakmicar;
import jwd.wafepa.support.TakmicarToTakmicarDTO;
import jwd.wafepa.web.dto.TakmicarDTO;

@RestController
@RequestMapping(value = "/api/takmicars")
public class ApiTakmicarController {

	@Autowired
	TakmicarService takmicarService;
	@Autowired
	TakmicarDTOToTakmicar dtoToTakmicar;
	@Autowired
	TakmicarToTakmicarDTO takmicarToDto;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TakmicarDTO>> getTakmicars(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {
		Page<Takmicar> taks = takmicarService.findAll(pageNum);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(taks.getTotalPages()));
		return new ResponseEntity<>(takmicarToDto.convert(taks.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TakmicarDTO> getTakmicar(@PathVariable Long id) {
		Takmicar takmicar = takmicarService.findOne(id);
		if (takmicar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(takmicarToDto.convert(takmicar), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TakmicarDTO> delete(@PathVariable Long id) {
		takmicarService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TakmicarDTO> add(@RequestBody TakmicarDTO newTakmicar) {

		Takmicar savedTak = takmicarService.save(dtoToTakmicar.convert(newTakmicar));
		return new ResponseEntity<>(takmicarToDto.convert(savedTak), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TakmicarDTO> edit(@RequestBody TakmicarDTO tak, @PathVariable Long id) {
		if (!id.equals(tak.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Takmicar persisted = takmicarService.save(dtoToTakmicar.convert(tak));
		return new ResponseEntity<>(takmicarToDto.convert(persisted), HttpStatus.OK);
	}

}
