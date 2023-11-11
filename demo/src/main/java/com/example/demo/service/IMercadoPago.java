package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMercadoPago {

    Preference mpCreateOrder(List<CartDto> details) throws MPException, MPApiException;

    ResponseEntity<String> webhookHandler(Long dataId);
}
