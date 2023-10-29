package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entities.Invoice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDto toDTO(Invoice invoice);

    List<InvoiceDto> toDTOs(List<Invoice> invoices);

    Invoice toEntity(InvoiceDto invoiceDto);
}
