package com.example.demo.service;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.enums.PaymentMethod;

import java.util.List;

public interface IInvoice {

    Invoice save(InvoiceDto invoiceDto);

    List<Invoice> findByPaymentMethod(PaymentMethod paymentMethod);

    Invoice findById(Integer id);

    List<Invoice> findAll();

}
