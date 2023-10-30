package com.example.demo.repository;

import com.example.demo.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findByName(String categoryName);
}
