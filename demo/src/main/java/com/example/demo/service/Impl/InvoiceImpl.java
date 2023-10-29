package com.example.demo.service.Impl;

import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entities.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.IInvoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceImpl implements IInvoice {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public Invoice save(InvoiceDto invoiceDto) {

        Invoice invoice = invoiceMapper.toEntity(invoiceDto);

        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> findByPaymentMethod(String paymentMethod) {
        return invoiceRepository.findByPaymentMethod(paymentMethod);
    }

    @Override
    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }
}
