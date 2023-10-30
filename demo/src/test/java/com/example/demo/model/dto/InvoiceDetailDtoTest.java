package com.example.demo.model.dto;
import com.example.demo.model.entities.Invoice;
import com.example.demo.model.entities.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceDetailDtoTest {

    @Test
    public void testConstructor() {
        Integer invoiceDetailId = 1;
        Integer quantity = 5;
        BigDecimal pricePerQuantity = new BigDecimal("25.99");
        Invoice fkInvoiceId = new Invoice(); // Puedes proporcionar una instancia de Invoice si es necesario
        Product fkProductId = new Product(); // Puedes proporcionar una instancia de Product si es necesario

        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto(invoiceDetailId, quantity, pricePerQuantity, fkInvoiceId, fkProductId);

        assertNotNull(invoiceDetailDto);
        assertEquals(invoiceDetailId, invoiceDetailDto.getInvoiceDetailId());
        assertEquals(quantity, invoiceDetailDto.getQuantity());
        assertEquals(pricePerQuantity, invoiceDetailDto.getPricePerQuantity());
        assertEquals(fkInvoiceId, invoiceDetailDto.getFkInvoiceId());
        assertEquals(fkProductId, invoiceDetailDto.getFkProductId());
    }

    @Test
    public void testBuilder() {
        Integer invoiceDetailId = 1;
        Integer quantity = 5;
        BigDecimal pricePerQuantity = new BigDecimal("25.99");
        Invoice fkInvoiceId = new Invoice(); // Puedes proporcionar una instancia de Invoice si es necesario
        Product fkProductId = new Product(); // Puedes proporcionar una instancia de Product si es necesario

        InvoiceDetailDto invoiceDetailDto = InvoiceDetailDto.builder()
                .invoiceDetailId(invoiceDetailId)
                .quantity(quantity)
                .pricePerQuantity(pricePerQuantity)
                .fkInvoiceId(fkInvoiceId)
                .fkProductId(fkProductId)
                .build();

        assertNotNull(invoiceDetailDto);
        assertEquals(invoiceDetailId, invoiceDetailDto.getInvoiceDetailId());
        assertEquals(quantity, invoiceDetailDto.getQuantity());
        assertEquals(pricePerQuantity, invoiceDetailDto.getPricePerQuantity());
        assertEquals(fkInvoiceId, invoiceDetailDto.getFkInvoiceId());
        assertEquals(fkProductId, invoiceDetailDto.getFkProductId());
    }
}