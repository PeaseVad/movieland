package com.pasechnik.movieland.service;

import com.pasechnik.movieland.common.CurrencyType;

import java.math.BigDecimal;

public interface CurrencyService {

    double getRateByCurrency(CurrencyType currencyType);
    void refreshCurrencyRate();

}
