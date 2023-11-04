package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.model.entity.Ticket;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class TicketMapper {

    public TicketDto toDTO(Ticket ticket) {
        return TicketDto.builder()
                .productSku(ticket.getProductSku())
                .productTitle(ticket.getProductTitle())
                .quantity(ticket.getQuantity())
                .unitPrice(ticket.getUnitPrice())
                .pricePerQuantity(ticket.getPricePerQuantity())
                .build();
    }

    public List<TicketDto> toDTOs(List<Ticket> tickets) {
        if (tickets == null) {
            return null;
        }

        List<TicketDto> list = new ArrayList<>();

        for (Ticket branch : tickets) {
            list.add(toDTO(branch));
        }

        return list;
    }

    public Ticket toEntity(ProductDto productDto) {
        return Ticket.builder()
                .productSku(productDto.getSku())
                .productTitle(productDto.getTitle())
                .quantity(1)
                .unitPrice(productDto.getUnitPrice())
                .pricePerQuantity(productDto.getUnitPrice())
                .build();
    }
}
