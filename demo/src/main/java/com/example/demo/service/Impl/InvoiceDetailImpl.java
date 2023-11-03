package com.example.demo.service.Impl;

import com.example.demo.mapper.InvoiceDetailMapper;
import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.InvoiceDetailRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IInvoiceDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceDetailImpl implements IInvoiceDetail {

    private final InvoiceDetailRepository invoiceDetailRepository;
    private final ProductRepository productRepository;
//    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceDetailImpl(InvoiceDetailRepository invoiceDetailRepository, ProductRepository productRepository, InvoiceDetailMapper invoiceDetailMapper) {
        this.invoiceDetailRepository = invoiceDetailRepository;
        this.productRepository = productRepository;
//        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailMapper = invoiceDetailMapper;
    }

    @Transactional
    @Override
    public InvoiceDetail save(InvoiceDetailDto invoiceDetailDto, Invoice invoice) {

        Product product = productRepository.findBySku(invoiceDetailDto.getProductSku());

        InvoiceDetail invoiceDetail = invoiceDetailMapper.toEntity(invoiceDetailDto, product, invoice);
        invoiceDetailRepository.save(invoiceDetail);

        return invoiceDetail;
    }

    /*@Transactional(readOnly = true)
    @Override
    public List<InvoiceDetail> findAll() {
        return (List<InvoiceDetail>) invoiceDetailRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<InvoiceDetail> findAllByInvoiceId(Integer invoiceId) {

        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) return null;

        return invoiceDetailRepository.findAllByFkInvoiceId(invoice);
    }*/
}
