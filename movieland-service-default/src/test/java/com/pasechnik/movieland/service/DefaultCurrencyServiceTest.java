package com.pasechnik.movieland.service;

import com.pasechnik.movieland.common.CurrencyType;
import com.pasechnik.movieland.entity.Currency;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class DefaultCurrencyServiceTest {

    @Test
    public void getRateByCurrency() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        DefaultCurrencyService defaultCurrencyService = new DefaultCurrencyService();
        defaultCurrencyService.setRestTemplate(restTemplate);

        List<Currency> currencies = new ArrayList<>();
        Currency currency = new Currency();
        currency.setCurrencyCode("USD");
        currency.setRate(27.8);
        currencies.add(currency);

        ResponseEntity<List<Currency>> response = new ResponseEntity<>(currencies, HttpStatus.OK);
        ParameterizedTypeReference<List<Currency>> parameterizedTypeReference = new ParameterizedTypeReference<List<Currency>>() {
        };

        // When
        when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(parameterizedTypeReference.getClass()))).thenReturn(response);

        defaultCurrencyService.refreshCurrencyRate();
        double actualRate = defaultCurrencyService.getRateByCurrency(CurrencyType.USD);

        assertEquals(27.8, actualRate, 0.1);
    }
}
