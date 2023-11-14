/*
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
    private PaymentMethod paymentMethod;
    private Long mercadopagoInvoiceId;
    private BigDecimal discount;
    private BigDecimal total;
    private List<InvoiceDetailDto> invoiceDetailDtos;

    public InvoiceDto(PaymentMethod paymentMethod, Long mercadopagoInvoiceId, BigDecimal discount, BigDecimal total, List<InvoiceDetailDto> invoiceDetailDtos) {
        this.paymentMethod = paymentMethod;
        this.mercadopagoInvoiceId = mercadopagoInvoiceId;
    public InvoiceDto( PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, List<InvoiceDetailDto> invoiceDetailDtos) {
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.invoiceDetailDtos = invoiceDetailDtos;
    }
}
*/
+