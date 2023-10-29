package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDetailDto;
import com.example.demo.model.entities.InvoiceDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {

    InvoiceDetailDto toDTO(InvoiceDetail invoice);

    List<InvoiceDetailDto> toDTOs(List<InvoiceDetail> invoices);
}
