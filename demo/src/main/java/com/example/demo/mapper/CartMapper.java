package com.example.demo.mapper;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class CartMapper {

    public CartDto toLinkedList(ProductResponseDto product) {
        return CartDto.builder()
                .productSku(product.getSku())
                .productTitle(product.getTitle())
                .productBrand(product.getBrand())
                .productSize(product.getSize())
                .quantity(1)
                .unitPrice(product.getUnitPrice())
                .pricePerQuantity(product.getUnitPrice())
                .build();
    }
}
