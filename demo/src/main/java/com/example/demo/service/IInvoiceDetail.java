package com.example.demo.service;

import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entity.InvoiceDetail;

import java.util.List;

public interface IInvoiceDetail {
    InvoiceDetail save(InvoiceDetailDto invoiceDetailDto);

    List<InvoiceDetail> findAll();

    List<InvoiceDetail> findAllByInvoiceId(Integer invoiceId);
}
