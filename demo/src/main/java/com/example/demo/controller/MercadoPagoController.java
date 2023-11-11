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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class MercadoPagoController {
    private final IMercadoPago mercadoPagoService;
    private final IInvoice invoiceService;
    private final ICart cartService;

    public MercadoPagoController(IMercadoPago mercadoPagoService, IInvoice invoiceService, ICart cartService) {
        this.mercadoPagoService = mercadoPagoService;
        this.invoiceService = invoiceService;
        this.cartService = cartService;
    }

    @PostMapping("/create_order")
    public ResponseEntity<?> createOrder() throws MPException, MPApiException {

        List<CartDto> cart = cartService.findAll();
        if (cart.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Cart is empty")
                    .build(), HttpStatus.OK);
        }

        Preference preference = mercadoPagoService.mpCreateOrder(cart);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(preference.getInitPoint())
                .build(), HttpStatus.OK);
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> webhook(
            @RequestParam(value = "data.id") Long dataId,
            @RequestParam(value = "type") String type) {

        if ("payment".equals(type)) {
//            System.out.println("?data.id=" + dataId + "&type=" + type);
            String payment = mercadoPagoService.webhookHandler(dataId).getBody();
            JSONObject body = new JSONObject(payment);

            String status = body.getString("status");
            String statusDetail = body.getString("status_detail");

            if ("approved".equals(status) && "accredited".equals(statusDetail)) {
                List<CartDto> cart = cartService.findAll();

                invoiceService.save(
                        body.getEnum(PaymentMethod.class, body.getString("payment_type_id")),
                        body.getLong("id"),
                        body.getBigDecimal("transaction_amount"),
                        body.getFloat("coupon_amount"),
                        body.getString("date_approved"),
                        cart
                );
                cartService.deleteAll();
            }

            //System.out.println("{status=" + body.getString("status") + ", status_detail=" + body.getString("status_detail") + "}");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
