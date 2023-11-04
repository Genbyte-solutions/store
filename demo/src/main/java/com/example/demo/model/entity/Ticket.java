package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer ticketId;
    @Column(name = "product_sku", unique = true)
    private String productSku;
    @Column(name = "product_title", nullable = false)
    private String productTitle;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "price_per_quantity", nullable = false)
    private BigDecimal pricePerQuantity;
}
