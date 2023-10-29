package com.example.demo.model.entities;
import com.example.demo.model.enums.PaymentMethod;
import com.example.demo.model.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceDetailTest {

    private InvoiceDetail invoiceDetail;
    private Invoice invoice;
    private Product product;

    @BeforeEach
    public void setUp() {

        invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setPaymentMethod(PaymentMethod.CREDITO);
        invoice.setDiscount(new BigDecimal("10.50"));
        invoice.setTotal(new BigDecimal("100.00"));
        invoice.setFkBranchId(null); // Puedes proporcionar un valor de sucursal si es necesario
        invoice.setEmittedAt(null); // Puedes proporcionar una fecha de emisión si es necesario

        product = Product.builder()
                .productId(1)
                .sku("PROD-123")
                .unitPrice(new BigDecimal("499.99"))
                .brand("ExampleBrand")
                .size(Size.L)
                .stock(50)
                .fkCategoryId(null)
                .fkBranchId(null)
                .createdAt(null) // Asigna la fecha de creación actual
                .updatedAt(null) // Asigna la misma fecha actual como fecha de actualización
                .build();

        invoiceDetail = new InvoiceDetail();
        invoiceDetail.setInvoiceDetailId(1);
        invoiceDetail.setQuantity(5);
        invoiceDetail.setPricePerQuantity(new BigDecimal("25.99"));
        invoiceDetail.setFkInvoiceId(invoice); // Puedes proporcionar un valor de factura si es necesario
        invoiceDetail.setFkProductId(product); // Puedes proporcionar un valor de producto si es necesario
    }

    @Test
    public void testInvoiceDetailId() {
        assertEquals(1, invoiceDetail.getInvoiceDetailId());
    }

    @Test
    public void testQuantity() {
        assertEquals(5, invoiceDetail.getQuantity());
    }

    @Test
    public void testPricePerQuantity() {
        assertEquals(new BigDecimal("25.99"), invoiceDetail.getPricePerQuantity());
    }

    @Test
    public void testFkInvoiceId() {
        assertEquals(invoice, invoiceDetail.getFkInvoiceId());
    }

    @Test
    public void testFkProductId() {
        assertEquals(product, invoiceDetail.getFkProductId());
    }

    @Test
    public void testNoArgsConstructor() {
        InvoiceDetail newInvoiceDetail = new InvoiceDetail();
        assertNotNull(newInvoiceDetail);
    }

    @Test
    public void testAllArgsConstructor() {
        InvoiceDetail anotherInvoiceDetail = new InvoiceDetail(2, 10, new BigDecimal("19.99"), invoice, product);
        assertNotNull(anotherInvoiceDetail);
    }
}