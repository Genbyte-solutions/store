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
    private String sku;
    private String title;
    private String brand;
    private Size size;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal pricePerQuantity;

    public CartDto(String sku, String title, String brand, Size size, Integer quantity, BigDecimal unitPrice, BigDecimal pricePerQuantity) {
        this.sku = sku;
        this.title = title;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.pricePerQuantity = pricePerQuantity;
    }
}
