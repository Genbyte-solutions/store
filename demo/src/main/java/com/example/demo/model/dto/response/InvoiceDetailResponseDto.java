package com.example.demo.model.dto.response;


import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.enums.Size;
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
    private String productSku;
    private String productTitle;
    private String productBrand;
    private Size productSize;
    private Integer quantity;
    private BigDecimal pricePerQuantity;

    public InvoiceDetailResponseDto(Integer invoiceDetailId, String productSku, String productTitle, String productBrand, Size productSize, Integer quantity, BigDecimal pricePerQuantity) {
        this.invoiceDetailId = invoiceDetailId;
        this.productSku = productSku;
        this.productTitle = productTitle;
        this.productBrand = productBrand;
        this.productSize = productSize;
        this.quantity = quantity;
        this.pricePerQuantity = pricePerQuantity;
    }
}
