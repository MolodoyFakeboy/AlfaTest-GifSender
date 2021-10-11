package com.currency.exchange.client;

import com.currency.exchange.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif", url = "${gif.api.url}")
public interface GifApi {

    @GetMapping("?api_key=${gif.api_key}")
    ResponseEntity<Gif> getGif(@RequestParam("tag") String tag);
}
