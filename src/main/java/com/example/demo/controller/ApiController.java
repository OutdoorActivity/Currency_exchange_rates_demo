package com.example.demo.controller;

import com.example.demo.api.gifs.GifTranslateServiceBroke;
import com.example.demo.api.gifs.GifTranslateServiceRich;
import com.example.demo.api.currencies.HistoricalApiService;
import com.example.demo.api.currencies.LatestApiService;
import com.example.demo.pojo.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/v1")
public class ApiController {
    @Autowired
    private LatestApiService latestApiService;
    @Autowired
    private HistoricalApiService historicalApiService;
    @Autowired
    private GifTranslateServiceRich gifTranslateServiceRich;
    @Autowired
    private GifTranslateServiceBroke gifTranslateServiceBroke;

    @GetMapping("/latest/currencies")
    public Map<String, Double> getMapOfAllCurrencies() {
        return latestApiService.getMapOfAllCurrencies().getRates();
    }

    @GetMapping("/latest/info")
    public Currencies getInfoPage() {
        return latestApiService.getInfoPage();
    }

    @GetMapping("/latest/{symbols}")
    private Double getValueOfSpecificCurrency(@PathVariable("symbols") String symbols) {
        return latestApiService.getSpecificCurrency(symbols).getRates().get(symbols);
    }

    @GetMapping("/historical/{date}")
    private Currencies getHistoricalCurrencies(@PathVariable("date") String date,
                                               @RequestParam("app_id") String app_id,
                                               @RequestParam(value = "symbols", required = false) String symbols) throws IOException {
        return historicalApiService.getHistoricalCurrencies(date, app_id, symbols);
    }

    @GetMapping("/historical/info/{date}")
    private Currencies getInfoHistoricalPage(@PathVariable("date") String date,
                                             @RequestParam("app_id") String app_id) {
        return historicalApiService.getInfoHistoricalPage(date, app_id);
    }

    @GetMapping("/gifs/rich")
    public ModelAndView getGifRich() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("embed_url", gifTranslateServiceRich.getGifRich().getData().getEmbedUrl());
        modelAndView.setViewName("gifrich");
        return modelAndView;
    }

    @GetMapping("/gifs/broke")
    public ModelAndView getGifBroke() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("embed_url", gifTranslateServiceBroke.getGifBroke().getData().getEmbedUrl());
        modelAndView.setViewName("gifbroke");
        return modelAndView;
    }

    @GetMapping("/difference")
    public ModelAndView getDifference(@RequestParam("date") String date,
                                      @RequestParam("app_id") String app_id,
                                      @RequestParam("symbols") String symbols) throws IOException {
        Double todayValue = getValueOfSpecificCurrency(symbols);
        Double yesterdayValue = getHistoricalCurrencies(date, app_id, symbols).getRates().get(symbols);
        Double difference1 = todayValue - yesterdayValue;
        Double difference2 = yesterdayValue - todayValue;
        return (todayValue > yesterdayValue ? getGifRich()
                .addObject("todayValue", todayValue)
                .addObject("yesterdayValue", yesterdayValue)
                .addObject("difference", difference1)
                : getGifBroke()
                .addObject("todayValue", todayValue)
                .addObject("yesterdayValue", yesterdayValue)
                .addObject("difference", difference2));
    }

    @GetMapping()
    public ModelAndView getWelcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}



