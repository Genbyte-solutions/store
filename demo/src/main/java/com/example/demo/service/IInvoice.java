package com.example.demo.service;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entity.Invoice;

import java.util.List;

public interface IInvoice {

    Invoice save(InvoiceDto invoiceDto);

    List<Invoice> findByPaymentMethod(String paymentMethod);

    Invoice findById(Integer id);

    List<Invoice> findAll();

}
