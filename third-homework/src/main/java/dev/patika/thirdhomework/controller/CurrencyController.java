package dev.patika.thirdhomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final String usd_endpoint = "http://localhost:8081/currencyConverter/toTRY?USD=";
    private final String try_endpoint = "http://localhost:8081/currencyConverter/toUSD?TRY=";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/toTry")
    public String convertUsdToTry(@RequestParam double currencyUsd) {

        return restTemplate.getForEntity(usd_endpoint + currencyUsd, String.class).getBody();

    }

    @GetMapping("/toUsd")
    public String convertTryToUsd(@RequestParam double currencyTry) {

        return restTemplate.getForEntity(try_endpoint + currencyTry, String.class).getBody();

    }

}