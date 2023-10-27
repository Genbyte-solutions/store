package com.example.demo.service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entities.Category;

import java.util.List;

public interface ICategory {
    Category save(CategoryDto category);

    Category findByName(String categoryName);

    List<Category> findAll();

    void deleteById(Integer id);
}
