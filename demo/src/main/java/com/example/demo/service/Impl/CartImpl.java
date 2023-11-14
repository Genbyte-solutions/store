package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.ICart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartImpl implements ICart {
    private final List<CartDto> localCart = new ArrayList<>();

    @Override
    public void save(List<CartDto> cart) {
        System.out.println(cart.toString());
        for (CartDto product : cart) {
            localCart.add(CartDto.builder()
                    .sku(product.getSku())
                    .title(product.getTitle())
                    .brand(product.getBrand())
                    .size(product.getSize())
                    .quantity(product.getQuantity())
                    .unitPrice(product.getUnitPrice())
                    .pricePerQuantity(product.getPricePerQuantity())
                    .build());
        }
    }

    @Override
    public List<CartDto> findAll() {
        return localCart;
    }

    @Override
    public void deleteAll() {
        localCart.clear();
    }
}
