package com.example.demo.api.gifs;

import com.example.demo.pojo.gifs.Gifs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gif-translate-broke-api", url = "${url6}")
public interface GifTranslateServiceBroke {
    @GetMapping()
    Gifs getGifBroke();
}
