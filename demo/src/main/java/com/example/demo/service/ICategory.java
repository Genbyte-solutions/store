package com.example.demo.service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;

import java.util.List;

public interface ICategory {
    Category save(CategoryDto category);

    Category findById(Integer id);

    Category findByName(String categoryName);

    List<Category> findAll();

    void deleteById(Integer id);
}
