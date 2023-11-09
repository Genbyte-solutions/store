package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;

import java.util.List;

public interface ICart {
    void save(ProductResponseDto productResponseDto);

    void update(CartDto cartDto, Integer quantity, String productSku);

    List<CartDto> findAll();

    CartDto findByProductSku(String productSku);

    void deleteAll();

    void deleteByProductSku(CartDto productSku);
}
