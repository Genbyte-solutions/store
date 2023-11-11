package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.model.enums.PaymentMethod;
import com.example.demo.repository.InvoiceDetailRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.IInvoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceImpl implements IInvoice {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceImpl(InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Transactional
    @Override
    public void save(PaymentMethod paymentMethod, Long id, BigDecimal transactionAmount, Float discount, String dateApproved, List<CartDto> cart) {
        Invoice invoiceBuild = Invoice.builder()
                .paymentMethod(paymentMethod)
                .mercadopagoInvoiceId(id)
                .discount(new BigDecimal(discount))
                .total(transactionAmount)
                .emittedAt(dateApproved)
                .build();
        Invoice invoice = invoiceRepository.save(invoiceBuild);

        for (CartDto product : cart) {
            invoiceDetailRepository.save(InvoiceDetail.builder()
                    .productSku(product.getProductSku())
                    .productTitle(product.getProductTitle())
                    .productBrand(product.getProductBrand())
                    .productSize(product.getProductSize())
                    .quantity(product.getQuantity())
                    .pricePerQuantity(product.getPricePerQuantity())
                    .fkInvoiceId(invoice)
                    .build());
        }
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
