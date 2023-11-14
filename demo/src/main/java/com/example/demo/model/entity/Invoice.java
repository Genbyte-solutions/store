package com.example.demo.model.entity;

import com.example.demo.model.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @Column(name = "mercadopago_invoice_id", unique = true)
    private String mercadopagoInvoiceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "discount", nullable = false, precision = 10, scale = 2)
    @Column(name = "discount", nullable = false, precision = 3, scale = 2)
    private BigDecimal discount;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "emitted_at", updatable = false)
    private String emittedAt;
    @CreationTimestamp
    @Column(name = "emitted_at", updatable = false)
    private Timestamp emittedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "fkInvoiceId")
    List<InvoiceDetail> invoiceDetails;
}
