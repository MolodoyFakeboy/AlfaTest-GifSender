package com.currency.exchange.service;

import com.currency.exchange.model.Gif;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<Gif> getRandomGif(String tag);
}
