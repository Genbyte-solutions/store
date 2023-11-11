package com.example.demo.model.dto.response;

import com.example.demo.model.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
@Builder
public class InvoiceResponseDto {
    private Integer invoiceId;
    private Long mercadopagoInvoiceId;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private String emittedAt;
    private List<InvoiceDetailResponseDto> invoiceDetailResponseDtos;

    public InvoiceResponseDto(Integer invoiceId, Long mercadopagoInvoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, String emittedAt, List<InvoiceDetailResponseDto> invoiceDetailResponseDtos) {
        this.invoiceId = invoiceId;
        this.mercadopagoInvoiceId = mercadopagoInvoiceId;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.emittedAt = emittedAt;
        this.invoiceDetailResponseDtos = invoiceDetailResponseDtos;
    }
}
