package com.currency.exchange.service.Impl;

import com.currency.exchange.client.DownloadApi;
import com.currency.exchange.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class DownloadServiceImpl implements DownloadService {

    private DownloadApi downloadApi;

    @Autowired
    public DownloadServiceImpl(DownloadApi downloadApi) {
        this.downloadApi = downloadApi;
    }

    @Override
    public ResponseEntity<byte[]> getDownloadURL(String url) {
        return downloadApi.getDownloadURL(URI.create(url));
    }
}
