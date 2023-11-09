package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import java.util.List;

public interface IMercadoPago {

    Preference mercadoPagoTest(List<CartDto> details) throws MPException, MPApiException;
}
