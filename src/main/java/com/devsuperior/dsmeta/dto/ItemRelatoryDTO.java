package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.RelatoryProjection;

import java.time.LocalDate;

public class ItemRelatoryDTO extends SaleMinDTO{
    private String sellerName;

    public ItemRelatoryDTO(Long id, Double amount, LocalDate date, String sellerName) {
        super(id, amount, date);
        this.sellerName= sellerName;
    }

    public ItemRelatoryDTO(Sale entity) {
        super(entity);
        this.sellerName = entity.getSeller().getName();
    }

    public ItemRelatoryDTO(RelatoryProjection projection) {
        super.setId(projection.getId());
        super.setAmount(projection.getAmount());
        super.setDate(projection.getDate());
        this.sellerName = projection.getSellerName();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "ItemRelatoryDTO{" +
                "sellerName='" + sellerName + '\'' +
                "id='" + super.getId() + '\'' +
                "amount='" + super.getAmount() + '\'' +
                "date='" + super.getDate() + '\'' +
                '}';
    }
}
