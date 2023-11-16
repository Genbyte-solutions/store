package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.model.entity.Product;
import com.example.demo.model.enums.PaymentMethod;
import com.example.demo.repository.InvoiceDetailRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IInvoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceImpl implements IInvoice {

    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceImpl(InvoiceRepository invoiceRepository, ProductRepository productRepository, InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Transactional
    @Override
    public void save(PaymentMethod paymentMethod, Long id, BigDecimal transactionAmount, BigDecimal discount, String dateApproved, List<CartDto> cart) {
        Invoice invoiceBuild = Invoice.builder()
                .paymentMethod(paymentMethod)
                .mercadopagoInvoiceId(String.valueOf(id))
                .discount(transactionAmount)
                .total(transactionAmount)
                .emittedAt(dateApproved)
                .build();
        Invoice invoice = invoiceRepository.save(invoiceBuild);

        for (CartDto product : cart) {
            invoiceDetailRepository.save(InvoiceDetail.builder()
                    .productSku(product.getSku())
                    .productTitle(product.getTitle())
                    .productBrand(product.getBrand())
                    .productSize(product.getSize())
                    .quantity(product.getQuantity())
                    .pricePerQuantity(product.getPricePerQuantity())
                    .fkInvoiceId(invoice)
                    .build());
            Product updateProduct = productRepository.findBySku(product.getSku());
            updateProduct.setStock(updateProduct.getStock() - product.getQuantity());
            productRepository.save(updateProduct);
        }
    }

    @Override
    public Invoice findFirstByOrderByEmittedAt() {
        return invoiceRepository.findFirstByOrderByEmittedAt();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Invoice> findByPaymentMethod(PaymentMethod paymentMethod) {
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
