package com.example.demo.service;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.entity.Ticket;

import java.util.List;

public interface ITicket {
    void save(ProductResponseDto productResponseDto);

    void update(Ticket ticket, Integer quantity, String productSku);

    List<Ticket> findAll();

    Ticket findByProductSku(String productSku);

    void deleteAll();

    void deleteByProductSku(String productSku);
}
