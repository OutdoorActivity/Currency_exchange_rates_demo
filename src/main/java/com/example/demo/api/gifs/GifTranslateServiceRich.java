package com.example.demo.api.gifs;

import com.example.demo.pojo.gifs.Gifs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gif-translate-rich-api", url = "${url5}")
public interface GifTranslateServiceRich {
    @GetMapping()
    Gifs getGifRich();
}

