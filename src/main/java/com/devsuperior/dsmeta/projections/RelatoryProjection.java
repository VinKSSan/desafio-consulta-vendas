package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface RelatoryProjection {
    Long getId();
    LocalDate getDate();
    Double getAmount();
    String getSellerName();
}
