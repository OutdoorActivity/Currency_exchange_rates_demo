package com.example.demo.api.currencies;

import com.example.demo.pojo.Currencies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "currency-historical-api", url = "${url4}")
public interface HistoricalApiService {

    @GetMapping("{date}")
    Currencies getHistoricalCurrencies(@PathVariable("date") String date,
                                       @RequestParam("app_id") String app_id,
                                       @RequestParam(value = "symbols", required = false) String symbols);

    @GetMapping("{date}")
    Currencies getInfoHistoricalPage(@PathVariable("date") String date,
                                     @RequestParam("app_id") String app_id);
}
