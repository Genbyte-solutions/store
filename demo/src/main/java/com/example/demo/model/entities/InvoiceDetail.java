package com.example.demo.model.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

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

    public InvoiceDetail() {
    }

    public InvoiceDetail(Integer invoiceDetailId, Integer quantity, BigDecimal pricePerQuantity, Invoice fkInvoiceId, Product fkProductId) {
        this.invoiceDetailId = invoiceDetailId;
        this.quantity = quantity;
        this.pricePerQuantity = pricePerQuantity;
        this.fkInvoiceId = fkInvoiceId;
        this.fkProductId = fkProductId;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "invoiceDetailId=" + invoiceDetailId +
                ", quantity=" + quantity +
                ", pricePerQuantity=" + pricePerQuantity +
                ", fkInvoiceId=" + fkInvoiceId +
                ", fkProductId=" + fkProductId +
                '}';
    }

    public Integer getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(Integer invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerQuantity() {
        return pricePerQuantity;
    }

    public void setPricePerQuantity(BigDecimal pricePerQuantity) {
        this.pricePerQuantity = pricePerQuantity;
    }

    public Invoice getFkInvoiceId() {
        return fkInvoiceId;
    }

    public void setFkInvoiceId(Invoice fkInvoiceId) {
        this.fkInvoiceId = fkInvoiceId;
    }

    public Product getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(Product fkProductId) {
        this.fkProductId = fkProductId;
    }
}
