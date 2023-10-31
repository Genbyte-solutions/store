package com.example.demo.model.dto;

import com.example.demo.model.entity.Branch;
import com.example.demo.model.enums.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@Builder
public class ProductDto {
    private Integer productId;
    private String sku;
    private BigDecimal unitPrice;
    private String brand;
    private Size size;
    private Integer stock;
    private Branch fkBranchId;

    public ProductDto(Integer productId, String sku, BigDecimal unitPrice, String brand, Size size, Integer stock, Branch fkBranchId) {
        this.productId = productId;
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.brand = brand;
        this.size = size;
        this.stock = stock;
        this.fkBranchId = fkBranchId;
    }
}
