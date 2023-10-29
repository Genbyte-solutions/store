package com.example.demo.repository;

import com.example.demo.model.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findBySku(String sku);
}
