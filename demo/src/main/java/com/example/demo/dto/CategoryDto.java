package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CategoryDto {
    private Integer categoryId;
    private String name;
}
