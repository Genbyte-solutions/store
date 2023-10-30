package com.example.demo.model.entities;
import com.example.demo.model.enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceTest {
    private Invoice invoice;
    private Branch branch;
    private Timestamp timestamp;

    @BeforeEach
    public void setUp() {

        branch = new Branch();
        branch.setBranchId(1);
        branch.setAddress("123 Main St");
        branch.setZipCode("10001");

        timestamp = Timestamp.from(Instant.now());

        invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setPaymentMethod(PaymentMethod.CREDITO);
        invoice.setDiscount(new BigDecimal("10.50"));
        invoice.setTotal(new BigDecimal("100.00"));
        invoice.setFkBranchId(branch); // Puedes proporcionar un valor de sucursal si es necesario
        invoice.setEmittedAt(timestamp); // Puedes proporcionar una fecha de emisión si es necesario
    }

    @Test
    public void testInvoiceId() {
        assertEquals(1, invoice.getInvoiceId());
    }

    @Test
    public void testPaymentMethod() {
        assertEquals(PaymentMethod.CREDITO, invoice.getPaymentMethod());
    }

    @Test
    public void testDiscount() {
        assertEquals(new BigDecimal("10.50"), invoice.getDiscount());
    }

    @Test
    public void testTotal() {
        assertEquals(new BigDecimal("100.00"), invoice.getTotal());
    }

    @Test
    public void testFkBranchId() {
        assertEquals(branch, invoice.getFkBranchId());
    }

    @Test
    public void testEmittedAt() {
        assertEquals(timestamp, invoice.getEmittedAt());
    }

    @Test
    public void testNoArgsConstructor() {
        Invoice newInvoice = new Invoice();
        assertNotNull(newInvoice);
    }

    @Test
    public void testAllArgsConstructor() {
        Invoice anotherInvoice = new Invoice(2, PaymentMethod.EFECTIVO, new BigDecimal("5.75"), new BigDecimal("50.00"), null, null);
        assertNotNull(anotherInvoice);
    }
}