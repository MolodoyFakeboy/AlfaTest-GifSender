package com.currency.exchange.service;


import org.springframework.http.ResponseEntity;

public interface GifExchangeRateService {
   ResponseEntity<byte[]> getGifByRateCurenncy(String currency);
}

