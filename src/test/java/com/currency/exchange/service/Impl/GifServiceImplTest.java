package com.currency.exchange.service.Impl;

import com.currency.exchange.model.Gif;
import com.currency.exchange.service.GifService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class GifServiceImplTest {

    @Autowired
    private GifService gifService;

    @Test
    void getRandomGif() {
        ResponseEntity<Gif> gifResponseEntity = gifService.getRandomGif("rich");

        assertAll(
                () -> assertEquals(gifResponseEntity.getStatusCodeValue(), 200),
                () -> assertNotNull(gifResponseEntity.getBody())
        );
    }
}