package com.currency.exchange.service.Impl;

import com.currency.exchange.client.CurrencyApi;
import com.currency.exchange.model.ExchangeRate;
import com.currency.exchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyApi currencyApi;

    @Autowired
    public CurrencyServiceImpl(CurrencyApi currencyApi) {
        this.currencyApi = currencyApi;
    }

    @Override
    public ExchangeRate getExchangeRate(String date) {
        return currencyApi.getExchangeRate(date);
    }

    @Override
    public ExchangeRate getTodayExchangeRate() {
        return currencyApi.getTodayExchangeRate();
    }
}
