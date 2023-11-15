package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;

import java.util.List;

public interface ICart {
    void save(List<CartDto> cart);

    List<CartDto> findAll();

    void deleteAll();
}
