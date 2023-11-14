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
    private String mercadopagoInvoiceId;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private String emittedAt;
    private List<InvoiceDetailResponseDto> invoiceDetailResponseDtos;

    public InvoiceResponseDto(Integer invoiceId, String mercadopagoInvoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, String emittedAt, List<InvoiceDetailResponseDto> invoiceDetailResponseDtos) {
        this.invoiceId = invoiceId;
        this.mercadopagoInvoiceId = mercadopagoInvoiceId;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private Timestamp emittedAt;
    private List<InvoiceDetailResponseDto> invoiceDetailResponseDtos;

    public InvoiceResponseDto(Integer invoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, Timestamp emittedAt, List<InvoiceDetailResponseDto> invoiceDetailResponseDtos) {
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.emittedAt = emittedAt;
        this.invoiceDetailResponseDtos = invoiceDetailResponseDtos;
    }

}
