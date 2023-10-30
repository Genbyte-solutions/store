package com.example.demo.model.dto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryDtoTest {

    @Test
    public void testConstructor() {
        Integer categoryId = 1;
        String name = "Electronics";

        CategoryDto categoryDto = new CategoryDto(categoryId, name);

        assertNotNull(categoryDto);
        assertEquals(categoryId, categoryDto.getCategoryId());
        assertEquals(name, categoryDto.getName());
    }

    @Test
    public void testBuilder() {
        Integer categoryId = 1;
        String name = "Electronics";

        CategoryDto categoryDto = CategoryDto.builder()
                .categoryId(categoryId)
                .name(name)
                .build();

        assertNotNull(categoryDto);
        assertEquals(categoryId, categoryDto.getCategoryId());
        assertEquals(name, categoryDto.getName());
    }
}