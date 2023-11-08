package com.example.demo.service.Impl;

import com.example.demo.mapper.InvoiceDetailMapper;
import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.dto.InvoiceDto;
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
    private final InvoiceMapper invoiceMapper;

    private final InvoiceDetailRepository invoiceDetailRepository;
    private final InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceImpl(InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository, InvoiceMapper invoiceMapper, InvoiceDetailMapper invoiceDetailMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceDetailMapper = invoiceDetailMapper;
    }

    @Transactional
    @Override
    public Invoice save(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        invoice = invoiceRepository.save(invoice);

        for (InvoiceDetailDto invoiceDetail : invoiceDto.getInvoiceDetailDtos()) {
            InvoiceDetail invDetail = invoiceDetailMapper.toEntity(invoiceDetail, invoice);
            invoiceDetailRepository.save(invDetail);
        }
        invoice.setInvoiceDetails(invoiceDetailRepository.findAllByFkInvoiceId(invoice));
        setTotalAmount(invoice);

        return invoice;
    }

    public void setTotalAmount(Invoice invoice) {
        BigDecimal totalAmount = new BigDecimal(0);

        for (InvoiceDetail i : invoice.getInvoiceDetails()) {
            totalAmount = totalAmount.add(i.getPricePerQuantity());
        }

        invoice.setTotal(totalAmount);
        invoiceRepository.save(invoice);
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
