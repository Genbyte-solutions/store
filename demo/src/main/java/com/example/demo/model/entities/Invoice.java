package com.example.demo.model.entities;

import com.example.demo.model.enums.PaymentMethod;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "discount", nullable = false, precision = 3, scale = 2)
    private BigDecimal discount;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "fk_branch_id", referencedColumnName = "branch_id", nullable = false)
    private Branch fkBranchId;

    @CreationTimestamp
    @Column(name = "emitted_at", updatable = false)
    private Timestamp emittedAt;

    public Invoice() {
    }

    public Invoice(Integer invoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, Branch fkBranchId, Timestamp emittedAt) {
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.fkBranchId = fkBranchId;
        this.emittedAt = emittedAt;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", paymentMethod=" + paymentMethod +
                ", discount=" + discount +
                ", total=" + total +
                ", fkBranchId=" + fkBranchId +
                ", emittedAt=" + emittedAt +
                '}';
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Branch getFkBranchId() {
        return fkBranchId;
    }

    public void setFkBranchId(Branch fkBranchId) {
        this.fkBranchId = fkBranchId;
    }

    public Timestamp getEmittedAt() {
        return emittedAt;
    }

    public void setEmittedAt(Timestamp emitedAt) {
        this.emittedAt = emitedAt;
    }
}
