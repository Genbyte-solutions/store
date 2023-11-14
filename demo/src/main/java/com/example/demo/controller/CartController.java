package com.example.demo.controller;


import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ICart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
class CartController {
    private final ICart cartService;

    CartController(ICart cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addProductToTicket(@RequestBody List<CartDto> cart) {
        if (cart.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Cart is empty")
                    .build(), HttpStatus.BAD_REQUEST);
        }

        cartService.save(cart);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Added product")
                .build(), HttpStatus.OK);
    }

    @GetMapping("/cart/products")
    public ResponseEntity<?> findAll() {
        BigDecimal total = new BigDecimal(0);
        List<CartDto> cart = cartService.findAll();

        for (CartDto product : cart) {
            total = total.add(product.getPricePerQuantity());
        }

        return new ResponseEntity<>(ResponseMessage.builder()
                .message(String.valueOf(total))
                .object(cart)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/cart/clear")
    public ResponseEntity<?> deleteAll() {
        cartService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
