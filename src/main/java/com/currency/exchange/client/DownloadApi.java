package com.currency.exchange.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "download", url = "https://download")
public interface DownloadApi {

    @GetMapping
    ResponseEntity<byte[]> getDownloadURL(URI url);
}
