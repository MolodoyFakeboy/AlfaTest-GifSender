package com.currency.exchange.controller;

import com.currency.exchange.service.GifExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gif")
public class GifExchangeRateController {

    private GifExchangeRateService gifExchangeRateService;

    @Autowired
    public GifExchangeRateController(GifExchangeRateService gifExchangeRateService) {
        this.gifExchangeRateService = gifExchangeRateService;
    }

    @GetMapping
    public ResponseEntity<byte[]> getFunnyGif(@RequestParam(value = "base") String baseCurrency){
        return gifExchangeRateService.getGifByRateCurenncy(baseCurrency);
    }

}
