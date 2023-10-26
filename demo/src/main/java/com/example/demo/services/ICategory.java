package com.example.demo.services;

import com.example.demo.model.entities.Category;

import java.util.List;

public interface ICategory {
    Category save(Category category);

    Category findByName(String categoryName);

    List<Category> findAll();

    void deleteById(Integer id);
}
