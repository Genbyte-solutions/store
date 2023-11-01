package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entity.Invoice;
import com.example.demo.model.entity.InvoiceDetail;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class InvoiceDetailMapper {
    public abstract InvoiceDetailDto toDTO(InvoiceDetail invoice);

    public List<InvoiceDetailDto> toDTOs(List<InvoiceDetail> invoiceDetails) {
        if (invoiceDetails == null) {
            return null;
        }

        List<InvoiceDetailDto> list = new ArrayList<>();
        for (InvoiceDetail invoiceDetail : invoiceDetails) {
            list.add(toDTO(invoiceDetail));
        }

        return list;
    }

    public InvoiceDetail toEntity(InvoiceDetailDto invoiceDetailDto, Product product, Invoice invoice) {
        return InvoiceDetail.builder()
                .quantity(invoiceDetailDto.getQuantity())
                .pricePerQuantity(invoiceDetailDto.getPricePerQuantity())
                .fkProductId(product)
                .fkInvoiceId(invoice)
                .build();
    }
}
