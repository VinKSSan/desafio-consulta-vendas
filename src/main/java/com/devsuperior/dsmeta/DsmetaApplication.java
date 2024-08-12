package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.ItemRelatoryDTO;
import com.devsuperior.dsmeta.dto.ItemSumaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.RelatoryProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DsmetaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

}
