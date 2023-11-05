package com.example.demo.model.dto;

import com.example.demo.model.enums.Size;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class InvoiceDetailDto implements Serializable {
    private String productSku;
    private String productTitle;
    private String productBrand;
    private Size productSize;
    private Integer quantity;
    private BigDecimal pricePerQuantity;

    public InvoiceDetailDto(String productSku, String productTitle, String productBrand, Size productSize, Integer quantity, BigDecimal pricePerQuantity) {
        this.productSku = productSku;
        this.productTitle = productTitle;
        this.productBrand = productBrand;
        this.productSize = productSize;
        this.quantity = quantity;
        this.pricePerQuantity = pricePerQuantity;
    }
}
