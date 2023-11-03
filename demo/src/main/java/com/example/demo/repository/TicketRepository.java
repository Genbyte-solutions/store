package com.example.demo.repository;

import com.example.demo.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    Ticket findByProductSku(String productSku);

    void deleteByProductSku(String productSku);
}
