package com.example.demo.api.currencies;

import com.example.demo.pojo.Currencies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-latest-api", url = "${url2}")
public interface LatestApiService {

    @GetMapping()
    Currencies getMapOfAllCurrencies();

    @GetMapping()
    Currencies getSpecificCurrency(@RequestParam("symbols") String symbols);

    @GetMapping()
    Currencies getInfoPage();
}


