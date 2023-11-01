package com.example.demo.model.dto;

import com.example.demo.model.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
@Builder
public class InvoiceDto implements Serializable {
    private Integer invoiceId;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private Timestamp emittedAt;
    private List<InvoiceDetailDto> invoiceDetailDtos;

    public InvoiceDto(Integer invoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, Timestamp emittedAt, List<InvoiceDetailDto> invoiceDetailDtos) {
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.emittedAt = emittedAt;
        this.invoiceDetailDtos = invoiceDetailDtos;
    }
}
