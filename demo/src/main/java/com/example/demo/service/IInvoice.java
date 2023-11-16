package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public interface IInvoice {

    void save(PaymentMethod paymentMethod, Long mercadoPagoId, BigDecimal transactionAmount, BigDecimal discount, String dateApproved, List<CartDto> cartDtos);

    Invoice findFirstByOrderByEmittedAt();

    List<Invoice> findByPaymentMethod(PaymentMethod paymentMethod);

    Invoice findById(Integer id);

    List<Invoice> findAll();

}
