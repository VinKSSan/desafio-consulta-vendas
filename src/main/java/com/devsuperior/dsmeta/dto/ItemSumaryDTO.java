package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class ItemSumaryDTO {
    private String sellerName;
    private Double total;

    public ItemSumaryDTO() {
    }
    public ItemSumaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }
    public ItemSumaryDTO(Seller seller) {
        this.sellerName = seller.getName();
        this.total = seller.getSales().stream()
                .mapToDouble(Sale::getAmount)
                .sum();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "sellerName='" + sellerName + '\'' +
                ", total=" + total +
                '}';
    }
}
