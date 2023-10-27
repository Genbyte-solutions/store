package com.example.demo.model.dto;

import com.example.demo.model.entities.Invoice;
import com.example.demo.model.entities.Product;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class InvoiceDetailDto {
    private Integer invoiceDetailId;
    private Integer quantity;
    private BigDecimal pricePerQuantity;
    private Invoice fkInvoiceId;
    private Product fkProductId;
}
