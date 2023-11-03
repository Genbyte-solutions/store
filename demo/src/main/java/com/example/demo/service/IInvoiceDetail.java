package com.example.demo.service;

import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;

public interface IInvoiceDetail {
    InvoiceDetail save(InvoiceDetailDto invoiceDetailDto, Invoice invoice);
}
