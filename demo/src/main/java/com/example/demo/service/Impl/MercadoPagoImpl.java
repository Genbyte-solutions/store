package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.IMercadoPago;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoImpl implements IMercadoPago {

    private final Environment env;

    public MercadoPagoImpl(Environment env) {
        this.env = env;
    }

    @Override
    public Preference mercadoPagoTest(List<CartDto> cart) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken(env.getProperty("accessToken"));

        PreferenceClient preferenceClient = new PreferenceClient();
        List<PreferenceItemRequest> items = new ArrayList<>();

        for (CartDto product : cart) {
            items.add(PreferenceItemRequest.builder()
                    .id(product.getProductSku())
                    .title(product.getProductTitle())
                    .description(product.getProductBrand() + " " + product.getProductSize())
                    .unitPrice(product.getUnitPrice())
                    .currencyId("COL")
                    .quantity(product.getQuantity())
                    .build());
        }

        PreferenceBackUrlsRequest backUrls =
                PreferenceBackUrlsRequest.builder()
                        .success("http://localhost/success")
                        .pending("http://localhost/pending")
                        .failure("http://localhost/failure")
                        .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .build();

        return preferenceClient.create(preferenceRequest);
    }
}
