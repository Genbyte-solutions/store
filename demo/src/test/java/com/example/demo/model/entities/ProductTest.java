package com.example.demo.model.entities;
import com.example.demo.model.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    private Product product;
    private Category category;
    private Branch branch;

    private Timestamp timestamp;

    @BeforeEach
    public void setUp() {

        category = new Category();
        category.setCategoryId(1);
        category.setName("Electronics");

        branch = new Branch();
        branch.setBranchId(1);
        branch.setAddress("123 Main St");
        branch.setZipCode("10001");

        timestamp = Timestamp.from(Instant.now());

        product = Product.builder()
                .productId(1)
                .sku("PROD-123")
                .unitPrice(new BigDecimal("499.99"))
                .brand("ExampleBrand")
                .size(Size.L)
                .stock(50)
                .fkCategoryId(category)
                .fkBranchId(branch)
                .createdAt(timestamp) // Asigna la fecha de creación actual
                .updatedAt(timestamp) // Asigna la misma fecha actual como fecha de actualización
                .build();
    }

    @Test
    public void testProductId() {
        assertEquals(1, product.getProductId());
    }

    @Test
    public void testSku() {
        assertEquals("PROD-123", product.getSku());
    }

    @Test
    public void testUnitPrice() {
        assertEquals(new BigDecimal("499.99"), product.getUnitPrice());
    }

    @Test
    public void testBrand() {
        assertEquals("ExampleBrand", product.getBrand());
    }

    @Test
    public void testSize() {
        assertEquals(Size.L, product.getSize());
    }

    @Test
    public void testStock() {
        assertEquals(50, product.getStock());
    }

    @Test
    public void testFkCategoryId() {
        assertEquals(category, product.getFkCategoryId());
    }

    @Test
    public void testFkBranchId() {
        assertEquals(branch, product.getFkBranchId());
    }

    @Test
    public void testCreatedAt() {
        assertEquals(Timestamp.from(Instant.now()), product.getCreatedAt());
    }

    @Test
    public void testUpdatedAt() {
        assertEquals(Timestamp.from(Instant.now()), product.getUpdatedAt());
    }

    @Test
    public void testToString() {
        String expectedToString = "Product(productId=1, sku=PROD-123, unitPrice=499.99, brand=ExampleBrand, size=L, stock=50, fkCategoryId=Category(categoryId=1, name=Electronics), fkBranchId=Branch(branchId=1, address=123 Main St, zipCode=10001), createdAt="+timestamp.toString()+", updatedAt="+timestamp.toString()+")";
        assertEquals(expectedToString, product.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        Product newProduct = new Product();
        assertNotNull(newProduct);
    }

    @Test
    public void testAllArgsConstructor() {
        Product anotherProduct = new Product(2, "PROD-456", new BigDecimal("599.99"), "AnotherBrand", Size.L, 100, null, null, null, null);
        assertNotNull(anotherProduct);
    }
}