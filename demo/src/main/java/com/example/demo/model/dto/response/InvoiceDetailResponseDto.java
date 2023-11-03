package com.example.demo.model.dto.response;


import com.example.demo.model.dto.ProductDto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class InvoiceDetailResponseDto implements Serializable {

    private Integer invoiceDetailId;
    private Integer quantity;
    private BigDecimal pricePerQuantity;
    private ProductDto productDto;

    public InvoiceDetailResponseDto(Integer invoiceDetailId, Integer quantity, BigDecimal pricePerQuantity, ProductDto productDto) {
        this.invoiceDetailId = invoiceDetailId;
        this.quantity = quantity;
        this.pricePerQuantity = pricePerQuantity;
        this.productDto = productDto;
    }
}
