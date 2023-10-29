package com.example.demo.service;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface IInvoice {

    Invoice save(InvoiceDto invoiceDto);

    List<Invoice> findByPaymentMethod(String paymentMethod);

    Optional<Invoice> findById(Integer id);

    List<Invoice> findAll();

}
