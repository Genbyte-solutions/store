package com.example.demo.controller;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.enums.PaymentMethod;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ICart;
import com.example.demo.service.IInvoice;
import com.example.demo.service.IMercadoPago;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    private final IMercadoPago mercadoPagoService;
    private final IInvoice invoiceService;
    private final ICart cartService;

    public PaymentController(IMercadoPago mercadoPagoService, IInvoice invoiceService, ICart cartService) {
        this.mercadoPagoService = mercadoPagoService;
        this.invoiceService = invoiceService;
        this.cartService = cartService;
    }

    @PostMapping("/cash_order")
    public ResponseEntity<?> cashCreateOrder(@RequestParam BigDecimal Amount, @RequestParam BigDecimal discount) {
        List<CartDto> cart = cartService.findAll();
        if (cart.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Cart is empty")
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }

        invoiceService.save(
                PaymentMethod.valueOf("cash"),
                null,
                Amount,
                discount,
                String.valueOf(new Date()),
                cart
        );
        cartService.deleteAll();

        return new ResponseEntity<>(ResponseMessage.builder().build(), HttpStatus.CREATED);
    }

    @PostMapping("/mercadopago/create_order")
    public ResponseEntity<?> createOrder() throws MPException, MPApiException {

        List<CartDto> cart = cartService.findAll();
        if (cart.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Cart is empty")
                    .build(), HttpStatus.BAD_REQUEST);
        }

        Preference preference = mercadoPagoService.mpCreateOrder(cart);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(preference)
                .build(), HttpStatus.CREATED);
    }

    @PostMapping("/mercadopago/webhook")
    public ResponseEntity<?> webhook(
            @RequestParam(value = "data.id") Long dataId,
            @RequestParam(value = "type") String type) {

        if ("payment".equals(type)) {
            System.out.println("?data.id=" + dataId + "&type=" + type);
            String payment = mercadoPagoService.webhookHandler(dataId).getBody();
            JSONObject body = new JSONObject(payment);

            String status = body.getString("status");
            String statusDetail = body.getString("status_detail");

//            System.out.println("{status=" + body.getString("status") + ", status_detail=" + body.getString("status_detail") + "}");
            if ("approved".equals(status) && "accredited".equals(statusDetail)) {
                List<CartDto> cart = cartService.findAll();
                invoiceService.save(
                        PaymentMethod.valueOf(body.getString("payment_type_id")),
                        body.getLong("id"),
                        body.getBigDecimal("transaction_amount"),
                        body.getBigDecimal("coupon_amount"),
                        body.getString("date_approved"),
                        cart
                );
                cartService.deleteAll();
            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
