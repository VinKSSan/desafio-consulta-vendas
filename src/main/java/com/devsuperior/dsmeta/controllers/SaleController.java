package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.ItemRelatoryDTO;
import com.devsuperior.dsmeta.dto.ItemSumaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<ItemRelatoryDTO>> getReport(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name="maxDate", defaultValue = "") String maxDate,
			@RequestParam(name = "name", defaultValue = "") String name,
			Pageable pageable
	) {
		Page<ItemRelatoryDTO> dto = service.getReport(minDate, maxDate, name, pageable);
		return  ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<ItemSumaryDTO>> getSummary(
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(name = "minDate", defaultValue="") String minDate,
			Pageable pageable
	) {
		Page<ItemSumaryDTO> dto =service.getSummary(maxDate, minDate, pageable);
		return  ResponseEntity.ok(dto);
	}

}
