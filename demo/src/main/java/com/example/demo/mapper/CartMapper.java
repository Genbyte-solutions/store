package com.example.demo.mapper;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Mapper(componentModel = "spring")
public class CartMapper {

    public CartDto toDTO(CartDto product) {
        return CartDto.builder()
                .productSku(product.getProductSku())
                .productTitle(product.getProductTitle())
                .productBrand(product.getProductBrand())
                .productSize(product.getProductSize())
                .quantity(product.getQuantity())
                .unitPrice(product.getUnitPrice())
                .pricePerQuantity(product.getPricePerQuantity())
                .build();
    }

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

    public List<CartDto> toDTOs(LinkedList<CartDto> products) {
        if (products == null) {
            return null;
        }

        List<CartDto> list = new ArrayList<>();

        for (CartDto product : products) {
            list.add(toDTO(product));
        }

        return list;
    }
}
