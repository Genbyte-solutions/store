package com.example.demo.mapper;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public abstract CategoryDto toDTO(Category category);

    // implemented by bingAI
    public List<CategoryDto> toDTOs(List<Category> categories) {
        if (categories == null) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(toDTO(category));
        }

        return list;
    }

    public abstract Category toEntity(CategoryDto categoryDto);
}
