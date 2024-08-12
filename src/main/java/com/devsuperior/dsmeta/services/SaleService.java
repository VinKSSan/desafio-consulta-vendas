package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.ItemRelatoryDTO;
import com.devsuperior.dsmeta.dto.ItemSumaryDTO;
import com.devsuperior.dsmeta.projections.RelatoryProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<ItemSumaryDTO> getSummary(String maxDate, String minDate, Pageable pageable) {
		LocalDate maxd ;
		LocalDate mind;
		if (maxDate.isEmpty()) {
			maxd = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		} else {
			maxd = LocalDate.parse(maxDate);
		}

		if (minDate.isEmpty()) {
			mind = maxd.minusYears(1L);
		} else {
			mind = LocalDate.parse(minDate);
		}
		return repository.getSumary(maxd, mind, pageable);
	}

	public Page<ItemRelatoryDTO> getReport(String minDate, String maxDate, String name , Pageable pageable) {
		LocalDate maxd ;
		LocalDate mind;
		if (maxDate.isEmpty()) {
			maxd = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		} else {
			maxd = LocalDate.parse(maxDate);
		}

		if (minDate.isEmpty()) {
			mind = maxd.minusYears(1L);
		} else {
			mind = LocalDate.parse(minDate);
		}
        return repository.getReport(mind, maxd, name, pageable);
	}

}