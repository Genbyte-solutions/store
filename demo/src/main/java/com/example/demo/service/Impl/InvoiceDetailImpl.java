package com.example.demo.service.Impl;

import com.example.demo.mapper.InvoiceDetailMapper;
import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.repository.InvoiceDetailRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.IInvoiceDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailImpl implements IInvoiceDetail {

    private final InvoiceDetailRepository invoiceDetailRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceDetailImpl(InvoiceDetailRepository invoiceDetailRepository, InvoiceRepository invoiceRepository, InvoiceDetailMapper invoiceDetailMapper) {
        this.invoiceDetailRepository = invoiceDetailRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailMapper = invoiceDetailMapper;
    }

    @Override
    public InvoiceDetail save(InvoiceDetailDto invoiceDetailDto) {

        InvoiceDetail invoiceDetail = invoiceDetailMapper.toEntity(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);

        return invoiceDetail;
    }

    @Override
    public List<InvoiceDetail> findAll() {
        return (List<InvoiceDetail>) invoiceDetailRepository.findAll();
    }

    @Override
    public List<InvoiceDetail> findAllByInvoiceId(Integer invoiceId) {

        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) return null;

        return invoiceDetailRepository.findAllByFkInvoiceId(invoice);
    }
}
