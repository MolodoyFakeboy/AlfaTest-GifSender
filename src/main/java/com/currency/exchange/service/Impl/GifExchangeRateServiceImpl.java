package com.currency.exchange.service.Impl;

import com.currency.exchange.service.DownloadService;
import com.currency.exchange.service.ExchangeRateService;
import com.currency.exchange.service.GifExchangeRateService;
import com.currency.exchange.service.GifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GifExchangeRateServiceImpl implements GifExchangeRateService {

    private GifService gifService;

    private ExchangeRateService exchangeRateService;

    private DownloadService downloadService;

    static final Logger log = LoggerFactory.getLogger(GifExchangeRateService.class);

    @Autowired
    public GifExchangeRateServiceImpl(GifService gifService, ExchangeRateService exchangeRateService, DownloadService downloadService) {
        this.gifService = gifService;
        this.exchangeRateService = exchangeRateService;
        this.downloadService = downloadService;
    }

    @Override
    public ResponseEntity<byte[]> getGifByRateCurenncy(String currency) {
        String tag = exchangeRateService.compareCurrencyRates(currency) ? "rich" : "broke";
        String url = Objects.requireNonNull(gifService.getRandomGif(tag).getBody()).getUrl();
        log.info("Gif успешно получена");
        return downloadService.getDownloadURL(url);
    }
}
