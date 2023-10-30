package com.example.demo.model.dto;

import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
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