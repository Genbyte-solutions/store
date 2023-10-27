package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CategoryDto {
    private Integer categoryId;
    private String name;

    public CategoryDto(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}