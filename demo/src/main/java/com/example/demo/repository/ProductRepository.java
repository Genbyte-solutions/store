package com.example.demo.repository;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findBySku(String sku);

    List<Product> findAllByFkCategoryId(Category category);

}
