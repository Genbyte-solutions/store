package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.entity.Invoice;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class InvoiceMapper {
    public abstract InvoiceDto toDTO(Invoice invoice);

    public List<InvoiceDto> toDTOs(List<Invoice> invoices) {
        if (invoices == null) {
            return null;
        }

        List<InvoiceDto> list = new ArrayList<>(invoices.size());

        for (Invoice invoice : invoices) {
            list.add(toDTO(invoice));
        }

        return list;
    }

    public abstract Invoice toEntity(InvoiceDto invoiceDto);
}
