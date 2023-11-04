package com.example.demo.service;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Ticket;

import java.util.List;

public interface ITicket {
    Ticket save(ProductDto productDto);

    void update(Ticket ticket, Integer quantity, String productSku);

    List<Ticket> findAll();

    Ticket findByProductSku(String productSku);

    void deleteAll();

    void deleteByProductSku(String productSku);
}
