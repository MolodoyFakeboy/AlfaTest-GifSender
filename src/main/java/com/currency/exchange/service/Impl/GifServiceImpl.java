package com.currency.exchange.service.Impl;

import com.currency.exchange.client.GifApi;
import com.currency.exchange.model.Gif;
import com.currency.exchange.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GifServiceImpl implements GifService {

    private GifApi gifApi;

    @Autowired
    public GifServiceImpl(GifApi gifApi) {
        this.gifApi = gifApi;
    }

    @Override
    public ResponseEntity<Gif> getRandomGif(String tag) {
        return gifApi.getGif(tag);
    }
}
