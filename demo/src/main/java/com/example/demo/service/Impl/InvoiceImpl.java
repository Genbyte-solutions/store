package com.example.demo.service.Impl;

import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.IInvoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceImpl implements IInvoice {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Transactional
    @Override
    public Invoice save(InvoiceDto invoiceDto) {

        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        return invoiceRepository.save(invoice);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Invoice> findByPaymentMethod(String paymentMethod) {
        return invoiceRepository.findAllByPaymentMethod(paymentMethod);
    }

    @Transactional(readOnly = true)
    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }
}
