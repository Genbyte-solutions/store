package com.example.demo.repository;

import com.example.demo.model.entity.Invoice;
import com.example.demo.model.enums.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
    List<Invoice> findAllByPaymentMethod(PaymentMethod paymentMethod);

    Invoice findFirstByOrderByEmittedAt();
}
