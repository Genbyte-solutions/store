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
public class ProductDto implements Serializable {
    private String sku;
    private String title;
    private BigDecimal unitPrice;
    private String brand;
    private Size size;
    private Integer stock;
    private BranchDto fkBranchId;

    public ProductDto(String sku, String title, BigDecimal unitPrice, String brand, Size size, Integer stock, BranchDto fkBranchId) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.brand = brand;
        this.size = size;
        this.stock = stock;
        this.fkBranchId = fkBranchId;
    }
}
