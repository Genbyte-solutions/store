package com.example.demo.model.dto;

import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.Product;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@Builder
public class InvoiceDetailDto {
    private Integer invoiceDetailId;
    private Integer quantity;
    private BigDecimal pricePerQuantity;
    private Product fkProductId;

    public InvoiceDetailDto(Integer invoiceDetailId, Integer quantity, BigDecimal pricePerQuantity, Product fkProductId) {
        this.invoiceDetailId = invoiceDetailId;
        this.quantity = quantity;
        this.pricePerQuantity = pricePerQuantity;
        this.fkProductId = fkProductId;
    }
}
