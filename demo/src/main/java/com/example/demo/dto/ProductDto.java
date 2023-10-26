package com.example.demo.dto;

import com.example.demo.model.entities.Branch;
import com.example.demo.model.entities.Category;
import com.example.demo.model.enums.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

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
    private Category fkCategoryId;
    private Branch fkBranchId;
}
