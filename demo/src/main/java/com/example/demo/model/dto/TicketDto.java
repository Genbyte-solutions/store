package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class TicketDto {
    private String productSku;
    private String productTitle;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal pricePerQuantity;

    public TicketDto(String productSku, String productTitle, Integer quantity, BigDecimal unitPrice, BigDecimal pricePerQuantity) {
        this.productSku = productSku;
        this.productTitle = productTitle;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.pricePerQuantity = pricePerQuantity;
    }
}
