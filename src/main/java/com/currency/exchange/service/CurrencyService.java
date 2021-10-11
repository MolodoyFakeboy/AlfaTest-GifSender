package com.currency.exchange.service;

import com.currency.exchange.model.ExchangeRate;


public interface CurrencyService {

    ExchangeRate getExchangeRate(String date);

    ExchangeRate getTodayExchangeRate();
}
