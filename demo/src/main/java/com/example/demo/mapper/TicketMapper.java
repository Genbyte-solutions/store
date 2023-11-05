package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.model.dto.response.ProductResponseDto;
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
                .productBrand(ticket.getProductBrand())
                .productSize(ticket.getProductSize())
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

    public Ticket toEntity(ProductResponseDto productResponseDto) {
        return Ticket.builder()
                .productSku(productResponseDto.getSku())
                .productTitle(productResponseDto.getTitle())
                .productBrand(productResponseDto.getBrand())
                .productSize(productResponseDto.getSize())
                .quantity(1)
                .unitPrice(productResponseDto.getUnitPrice())
                .pricePerQuantity(productResponseDto.getUnitPrice())
                .build();
    }
}
