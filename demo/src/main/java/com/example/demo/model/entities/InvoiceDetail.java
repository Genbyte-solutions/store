package com.example.demo.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Integer invoiceDetailId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_quantity", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerQuantity;

    @ManyToOne
    @JoinColumn(name = "fk_invoice_id", nullable = false)
    private Invoice fkInvoiceId;

    @ManyToOne
    @JoinColumn(name = "fk_product_id", nullable = false)
    private Product fkProductId;
}
