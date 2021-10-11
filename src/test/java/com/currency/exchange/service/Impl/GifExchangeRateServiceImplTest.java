package com.currency.exchange.service.Impl;

import com.currency.exchange.service.GifExchangeRateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GifExchangeRateServiceImplTest {

    @Autowired
    private GifExchangeRateService gifExchangeRateService;

    @Test
    void getGifByRateCurenncy() {
        ResponseEntity<byte[]> response = gifExchangeRateService.getGifByRateCurenncy("usd");

        assertAll(
                () -> assertTrue(response.hasBody()),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}