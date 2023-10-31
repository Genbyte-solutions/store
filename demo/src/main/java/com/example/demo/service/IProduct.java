package com.example.demo.service;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;

import java.util.List;

public interface IProduct {

    Product save(ProductDto productDto);

    Product findBySku(String productSku);

    List<Product> findAll();

    void deleteById(Integer id);
}
