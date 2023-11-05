package com.example.demo.model.entity;


import com.example.demo.model.enums.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Integer invoiceDetailId;

    @Column(name = "product_sku", nullable = false)
    private String productSku;

    @Column(name = "product_title", nullable = false)
    private String productTitle;

    @Column(name = "product_brand", nullable = false)
    private String productBrand;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_size", nullable = false)
    private Size productSize;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_quantity", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerQuantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_invoice_id", nullable = false)
    private Invoice fkInvoiceId;
}
