package com.example.demo.service.Impl;

import com.example.demo.mapper.CartMapper;
import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.service.ICart;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartImpl implements ICart {
    private final List<CartDto> cart = new ArrayList<>();
import java.util.LinkedList;

@Service
public class CartImpl implements ICart {
    private final LinkedList<CartDto> cart = new LinkedList<>();
    private final CartMapper cartMapper;

    public CartImpl(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public void save(ProductResponseDto productResponseDto) {
        CartDto newProduct = cartMapper.toLinkedList(productResponseDto);
        cart.add(newProduct);
    }

    @Override
    public void update(CartDto cart, Integer quantity, String productSku) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(cart.getUnitPrice()));

        cart.setQuantity(quantity);
        cart.setPricePerQuantity(bigDecimal.multiply(BigDecimal.valueOf(quantity)));
    }

    @Override
    public List<CartDto> findAll() {
    public LinkedList<CartDto> findAll() {
        return cart;
    }

    @Override
    public CartDto findByProductSku(String productSku) {

        for (CartDto product : cart) {
            if (productSku.equals(product.getProductSku())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteAll() {
        cart.clear();
    }

    @Override
    public void deleteByProductSku(CartDto product) {
        cart.remove(product);
    }
}
