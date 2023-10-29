package com.example.demo.model.dto;
import com.example.demo.model.entities.Branch;
import com.example.demo.model.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceDtoTest {

    @Test
    public void testConstructor() {
        Integer invoiceId = 1;
        PaymentMethod paymentMethod = PaymentMethod.CREDITO;
        BigDecimal discount = new BigDecimal("10.50");
        BigDecimal total = new BigDecimal("100.00");
        Branch fkBranchId = new Branch(); // Puedes proporcionar una instancia de Branch si es necesario
        Timestamp emittedAt = Timestamp.from(Instant.now()); // Usar el instante actual

        InvoiceDto invoiceDto = new InvoiceDto(invoiceId, paymentMethod, discount, total, fkBranchId, emittedAt);

        assertNotNull(invoiceDto);
        assertEquals(invoiceId, invoiceDto.getInvoiceId());
        assertEquals(paymentMethod, invoiceDto.getPaymentMethod());
        assertEquals(discount, invoiceDto.getDiscount());
        assertEquals(total, invoiceDto.getTotal());
        assertEquals(fkBranchId, invoiceDto.getFkBranchId());
        assertEquals(emittedAt, invoiceDto.getEmittedAt());
    }

    @Test
    public void testBuilder() {
        Integer invoiceId = 1;
        PaymentMethod paymentMethod = PaymentMethod.EFECTIVO;
        BigDecimal discount = new BigDecimal("5.75");
        BigDecimal total = new BigDecimal("50.00");
        Branch fkBranchId = new Branch(); // Puedes proporcionar una instancia de Branch si es necesario
        Timestamp emittedAt = Timestamp.from(Instant.now()); // Usar el instante actual

        InvoiceDto invoiceDto = InvoiceDto.builder()
                .invoiceId(invoiceId)
                .paymentMethod(paymentMethod)
                .discount(discount)
                .total(total)
                .fkBranchId(fkBranchId)
                .emittedAt(emittedAt)
                .build();

        assertNotNull(invoiceDto);
        assertEquals(invoiceId, invoiceDto.getInvoiceId());
        assertEquals(paymentMethod, invoiceDto.getPaymentMethod());
        assertEquals(discount, invoiceDto.getDiscount());
        assertEquals(total, invoiceDto.getTotal());
        assertEquals(fkBranchId, invoiceDto.getFkBranchId());
        assertEquals(emittedAt, invoiceDto.getEmittedAt());
    }
}