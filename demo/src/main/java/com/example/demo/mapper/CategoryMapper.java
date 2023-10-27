package com.example.demo.mapper;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDTO(Category category);

    List<CategoryDto> toDTOs(List<Category> categories);
}