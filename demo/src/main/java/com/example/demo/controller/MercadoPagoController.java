package com.example.demo.controller;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ICart;
import com.example.demo.service.IMercadoPago;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@RestController
@RequestMapping("/api/v1")
public class MercadoPagoController {

    private final IMercadoPago mercadoPago;
    private final ICart cartService;

    public MercadoPagoController(IMercadoPago mercadoPago, ICart cartService) {
        this.mercadoPago = mercadoPago;
        this.cartService = cartService;
    }

    @PostMapping("/mercadopago")
    public ResponseEntity<?> createOrder() throws MPException, MPApiException {

        List<CartDto> cart = cartService.findAll();
        if (cart.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Cart is empty")
                    .build(),HttpStatus.OK);
        }

        Preference preference = mercadoPago.mercadoPagoTest(cart);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(preference)
                .build(),HttpStatus.OK);
    }

}
