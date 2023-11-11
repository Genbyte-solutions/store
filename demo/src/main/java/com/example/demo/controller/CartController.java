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
    public ResponseEntity<?> addProductToTicket(@RequestBody ProductResponseDto productResponseDto) {

        CartDto cart = cartService.findByProductSku(productResponseDto.getSku());

        if (cart != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product has already been added")
                    .build(), HttpStatus.CONFLICT);
        }

        cartService.save(productResponseDto);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Added product")
                .build(), HttpStatus.OK);
    }

    @PatchMapping("/cart/update")
    public ResponseEntity<?> updateTicket(@RequestParam("quantity") Integer quantity, @RequestParam("productSku") String productSku) {

        CartDto cart = cartService.findByProductSku(productSku);

        if (cart == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product is not on the cart")
                    .build(), HttpStatus.NOT_FOUND);
        }

        cartService.update(cart, quantity, productSku);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @DeleteMapping("/cart")
    public ResponseEntity<?> deleteByProductSku(@RequestParam("sku") String sku) {

        CartDto cart = cartService.findByProductSku(sku);

        if (cart != null) {
            cartService.deleteByProductSku(cart);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cart/clean")
    public ResponseEntity<?> cleanTicket() {

        cartService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
