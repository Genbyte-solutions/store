package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.IMercadoPago;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoImpl implements IMercadoPago {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();

    public MercadoPagoImpl(Environment env) {
        this.env = env;
    }

    @Override
    public Preference mpCreateOrder(List<CartDto> cart) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken(env.getProperty("ACCESS_TOKEN"));

        PreferenceClient client = new PreferenceClient();
        List<PreferenceItemRequest> items = new ArrayList<>();

        for (CartDto product : cart) {
            items.add(PreferenceItemRequest.builder()
                    .id(product.getSku())
                    .title(product.getTitle() + " " + product.getBrand() + " " + product.getSize())
                    .unitPrice(product.getUnitPrice())
                    .currencyId("COL")
                    .quantity(product.getQuantity())
                    .build());
        }

        PreferenceBackUrlsRequest backUrls =
                PreferenceBackUrlsRequest.builder()
                        .success("http://localhost:8080/success")
                        .pending("http://localhost:8080/pending")
                        .failure("http://localhost:8080/failure")
                        .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .notificationUrl(env.getProperty("HTTPS_HOOK") + "/api/v1/mercadopago/webhook")
                .build();

        return client.create(preferenceRequest);
    }

    @Override
    public ResponseEntity<String> webhookHandler(Long dataId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + env.getProperty("ACCESS_TOKEN"));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://api.mercadopago.com/v1/payments/" + dataId;
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
