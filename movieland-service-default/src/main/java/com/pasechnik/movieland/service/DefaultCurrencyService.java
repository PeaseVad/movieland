package com.pasechnik.movieland.service;

import com.pasechnik.movieland.common.CurrencyType;
import com.pasechnik.movieland.entity.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Service
public class DefaultCurrencyService implements CurrencyService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private volatile HashMap<String, Double> currencyMap;
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.nbu_api}")
    private String apiUrl;

    @Override
    public double getRateByCurrency(CurrencyType currencyType) {
        return currencyMap.get(currencyType.name());
    }

    @Override
    @PostConstruct
    @Scheduled(cron = "${schedule.cron_value}")
    public void refreshCurrencyRate() {

        ResponseEntity<List<Currency>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Currency>>() {
        });
        List<Currency> currencies = response.getBody();
        HashMap<String, Double> tempCurrencyMap = new HashMap<>();
        for (Currency currency : currencies) {
            if (currency.getCurrencyCode().equalsIgnoreCase(CurrencyType.EUR.value()) ||
                    currency.getCurrencyCode().equalsIgnoreCase(CurrencyType.USD.value())) {
                tempCurrencyMap.put(currency.getCurrencyCode(), currency.getRate());
            }
        }
        currencyMap = tempCurrencyMap;
        logger.debug("Refresh for currency was completed, size {} rows", currencyMap.size());
    }
}



