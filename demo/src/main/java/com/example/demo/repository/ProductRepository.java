package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findBySku (String sku);
    @Query("SELECT p FROM Product p WHERE p.title LIKE %:search% OR p.sku LIKE %:search%")
    List<Product> findByTitleOrSku(@Param("search") String search);

}
