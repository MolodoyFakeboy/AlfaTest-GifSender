package com.currency.exchange.client;

import com.currency.exchange.model.ExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency", url = "${currency.url}")
public interface CurrencyApi  {

    @GetMapping("/historical/{date}.json?app_id=${currency.api_key}")
    ExchangeRate getExchangeRate(@PathVariable String date);

    @GetMapping("latest.json?app_id=${currency.api_key}")
    ExchangeRate getTodayExchangeRate();
}
