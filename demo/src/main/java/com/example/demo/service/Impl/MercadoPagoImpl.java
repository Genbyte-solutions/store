package com.example.demo.service.Impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.IMercadoPago;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferenceTax;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoImpl implements IMercadoPago {

    @Value("${ACCESS_TOKEN}")
    private String accessToken;

    @Value("${HTTPS_GNROK}")
    private String httpsWebhook;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Preference mpCreateOrder(List<CartDto> cart) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken(accessToken);

        PreferenceClient client = new PreferenceClient();
        List<PreferenceItemRequest> items = new ArrayList<>();

        for (CartDto product : cart) {
            items.add(PreferenceItemRequest.builder()
                    .id(product.getProductSku())
                    .title(product.getProductTitle())
                    .description("Marca: " + product.getProductBrand() + " - Talla: " + product.getProductSize())
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
                .notificationUrl(httpsWebhook + "/api/v1/webhook")
                .build();

        return client.create(preferenceRequest);
    }

    @Override
    public ResponseEntity<String> webhookHandler(Long dataId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://api.mercadopago.com/v1/payments/" + dataId;
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
