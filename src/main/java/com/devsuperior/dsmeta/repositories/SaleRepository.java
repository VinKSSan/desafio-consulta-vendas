package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.ItemRelatoryDTO;
import com.devsuperior.dsmeta.dto.ItemSumaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.ItemSumaryDTO( sa.seller.name, SUM(sa.amount)) " +
            "FROM Sale sa "  +
            "WHERE sa.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY sa.seller.name " +
            "ORDER BY sa.seller.name")
    Page<ItemSumaryDTO> getSumary(LocalDate maxDate, LocalDate minDate, Pageable pageable);

    @Query("SELECT new com.devsuperior.dsmeta.dto.ItemRelatoryDTO(sa.id, sa.amount, sa.date, sa.seller.name) FROM Sale sa " +
            "WHERE sa.date BETWEEN :minDate AND :maxDate " +
            "AND UPPER(sa.seller.name) LIKE UPPER(CONCAT('%',:name,'%')) " +
            "ORDER BY sa.amount")
    Page<ItemRelatoryDTO> getReport( LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);
}
