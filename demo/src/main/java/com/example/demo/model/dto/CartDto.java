package com.example.demo.model.dto;

import com.example.demo.model.enums.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class CartDto implements Serializable {
    private String productSku;
    private String productTitle;
    private String productBrand;
    private Size productSize;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal pricePerQuantity;

    public CartDto(String productSku, String productTitle, String productBrand, Size productSize, Integer quantity, BigDecimal unitPrice, BigDecimal pricePerQuantity) {
        this.productSku = productSku;
        this.productTitle = productTitle;
        this.productBrand = productBrand;
        this.productSize = productSize;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.pricePerQuantity = pricePerQuantity;
    }
}
