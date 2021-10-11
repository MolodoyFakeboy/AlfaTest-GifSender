package com.currency.exchange.service;

import org.springframework.http.ResponseEntity;

public interface DownloadService {
    ResponseEntity<byte[]> getDownloadURL(String url);
}
