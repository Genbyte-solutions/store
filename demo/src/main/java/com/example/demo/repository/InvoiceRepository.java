package com.example.demo.repository;

import com.example.demo.model.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
    List<Invoice> findByPaymentMethod(String paymentMethod);
}
