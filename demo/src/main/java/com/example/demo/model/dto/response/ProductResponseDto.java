package com.example.demo.model.dto.response;

import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.enums.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class ProductResponseDto implements Serializable {
    private Integer productId;
    private String sku;
    private String title;
    private BigDecimal unitPrice;
    private String brand;
    private Size size;
    private Integer stock;

    public ProductResponseDto(Integer productId, String sku, String title, BigDecimal unitPrice, String brand, Size size, Integer stock) {
        this.productId = productId;
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.brand = brand;
        this.size = size;
        this.stock = stock;
    }
}
