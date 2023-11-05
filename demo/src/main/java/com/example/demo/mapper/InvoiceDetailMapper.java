package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.dto.response.InvoiceDetailResponseDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class InvoiceDetailMapper {

    @Autowired
    public ProductMapper productMapper;

    public InvoiceDetailResponseDto toDTO(InvoiceDetail invoiceDetail) {
        return InvoiceDetailResponseDto.builder()
                .invoiceDetailId(invoiceDetail.getInvoiceDetailId())
                .productSku(invoiceDetail.getProductSku())
                .productTitle(invoiceDetail.getProductTitle())
                .productBrand(invoiceDetail.getProductBrand())
                .productSize(invoiceDetail.getProductSize())
                .quantity(invoiceDetail.getQuantity())
                .pricePerQuantity(invoiceDetail.getPricePerQuantity())
                .build();
    }

    public List<InvoiceDetailResponseDto> toDTOs(List<InvoiceDetail> invoiceDetails) {
        if (invoiceDetails == null) {
            return null;
        }

        List<InvoiceDetailResponseDto> list = new ArrayList<>();
        for (InvoiceDetail invoiceDetail : invoiceDetails) {
            list.add(toDTO(invoiceDetail));
        }

        return list;
    }

    public InvoiceDetail toEntity(InvoiceDetailDto invoiceDetailDto, Invoice invoice) {
        return InvoiceDetail.builder()
                .productSku(invoiceDetailDto.getProductSku())
                .productTitle(invoiceDetailDto.getProductTitle())
                .productBrand(invoiceDetailDto.getProductBrand())
                .productSize(invoiceDetailDto.getProductSize())
                .quantity(invoiceDetailDto.getQuantity())
                .pricePerQuantity(invoiceDetailDto.getPricePerQuantity())
                .fkInvoiceId(invoice)
                .build();
    }
}
