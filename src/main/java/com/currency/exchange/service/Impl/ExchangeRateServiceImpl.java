package com.currency.exchange.service.Impl;

import com.currency.exchange.model.ExchangeRate;
import com.currency.exchange.service.CurrencyService;
import com.currency.exchange.service.ExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private CurrencyService currencyService;

    static final Logger log = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);

    @Autowired
    public ExchangeRateServiceImpl(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public boolean compareCurrencyRates(String currency) {
        ExchangeRate todayRate = getTodayRates();
        ExchangeRate yesterdayRate = getYesterdayRates();
        double todayDifference = differenceBetweenBaseCurrencyToRub(todayRate,currency);
        double yesterdayDiffrence = differenceBetweenBaseCurrencyToRub(yesterdayRate,currency);
        boolean result = todayDifference >= yesterdayDiffrence;
        log.info("Успешно получил результат");
        return result;
    }

    /*так как доллар является основной валютой по отношению к другим валютам
    то получаем курс сравнимой валюты к доллару, потом курс рубля к доллару
    и делим курс рубля на курс "base" валюты */
    private double differenceBetweenBaseCurrencyToRub(ExchangeRate exchangeRate,String currency){
        Map<String,Double> rates = exchangeRate.getRates();
        double dollarToBase = rates.get(currency.toUpperCase());
        double dollarToRub = rates.get("RUB");
        double result = dollarToRub/dollarToBase;
        log.info("Сравниваю курс валюты к рублю");
        return result;
    }

    private ExchangeRate getTodayRates(){
        log.info("Получил курс валют на сегодня");
        return currencyService.getTodayExchangeRate();
    }

    private ExchangeRate getYesterdayRates(){
        String yesterday = formatDateFromNow();
        log.info("Получаю вчерашние курсы валют");
        return currencyService.getExchangeRate(yesterday);
    }

    private String formatDateFromNow() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
    }

}
