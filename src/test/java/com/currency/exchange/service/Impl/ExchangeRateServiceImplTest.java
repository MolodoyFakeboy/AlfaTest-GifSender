package com.currency.exchange.service.Impl;

import com.currency.exchange.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ExchangeRateServiceImplTest {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    void compareCurrencyRates() {
        boolean result = exchangeRateService.compareCurrencyRates("azn");
        //т.к курс валют уменьшился сегодня по отношению к рублю, то возращается фолс
        Assertions.assertFalse(result);
    }
}