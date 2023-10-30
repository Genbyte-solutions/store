package com.example.demo.model.dto;
import com.example.demo.model.entities.Branch;
import com.example.demo.model.entities.Category;
import com.example.demo.model.enums.Size;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductDtoTest {

    @Test
    public void testConstructor() {
        Integer productId = 1;
        String sku = "PROD-123";
        BigDecimal unitPrice = new BigDecimal("499.99");
        String brand = "ExampleBrand";
        Size size = Size.L;
        Integer stock = 50;
        Category fkCategoryId = new Category(); // Puedes proporcionar una instancia de Category si es necesario
        Branch fkBranchId = new Branch(); // Puedes proporcionar una instancia de Branch si es necesario

        ProductDto productDto = new ProductDto(productId, sku, unitPrice, brand, size, stock, fkCategoryId, fkBranchId);

        assertNotNull(productDto);
        assertEquals(productId, productDto.getProductId());
        assertEquals(sku, productDto.getSku());
        assertEquals(unitPrice, productDto.getUnitPrice());
        assertEquals(brand, productDto.getBrand());
        assertEquals(size, productDto.getSize());
        assertEquals(stock, productDto.getStock());
        assertEquals(fkCategoryId, productDto.getFkCategoryId());
        assertEquals(fkBranchId, productDto.getFkBranchId());
    }

    @Test
    public void testBuilder() {
        Integer productId = 2;
        String sku = "PROD-456";
        BigDecimal unitPrice = new BigDecimal("299.99");
        String brand = "AnotherBrand";
        Size size = Size.M;
        Integer stock = 25;
        Category fkCategoryId = new Category(); // Puedes proporcionar una instancia de Category si es necesario
        Branch fkBranchId = new Branch(); // Puedes proporcionar una instancia de Branch si es necesario

        ProductDto productDto = ProductDto.builder()
                .productId(productId)
                .sku(sku)
                .unitPrice(unitPrice)
                .brand(brand)
                .size(size)
                .stock(stock)
                .fkCategoryId(fkCategoryId)
                .fkBranchId(fkBranchId)
                .build();

        assertNotNull(productDto);
        assertEquals(productId, productDto.getProductId());
        assertEquals(sku, productDto.getSku());
        assertEquals(unitPrice, productDto.getUnitPrice());
        assertEquals(brand, productDto.getBrand());
        assertEquals(size, productDto.getSize());
        assertEquals(stock, productDto.getStock());
        assertEquals(fkCategoryId, productDto.getFkCategoryId());
        assertEquals(fkBranchId, productDto.getFkBranchId());
    }
}