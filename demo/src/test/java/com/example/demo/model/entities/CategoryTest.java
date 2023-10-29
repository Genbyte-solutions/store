package com.example.demo.model.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {

    private Category category;

    @BeforeEach
    public void setUp() {
        category = Category.builder()
                .categoryId(1)
                .name("Electronics")
                .build();
    }

    @Test
    public void testCategoryId() {
        assertEquals(1, category.getCategoryId());
    }

    @Test
    public void testName() {
        assertEquals("Electronics", category.getName());
    }

    @Test
    public void testNoArgsConstructor() {
        Category newCategory = new Category();
        assertNotNull(newCategory);
    }

    @Test
    public void testAllArgsConstructor() {
        Category anotherCategory = new Category(2, "Clothing");
        assertNotNull(anotherCategory);
    }
}