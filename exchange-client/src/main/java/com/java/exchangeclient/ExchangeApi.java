package com.java.exchangeclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeApi {

    private final ExchangeClientService exchangeClientService;

    public ExchangeApi(ExchangeClientService exchangeClientService) {
        this.exchangeClientService = exchangeClientService;
    }

    @GetMapping("/exchange-rate")
    public String getExchangeRate(@RequestParam("currencyCode") String currencyCode) {
        // gRPC 클라이언트를 호출하여 결과를 반환
        return exchangeClientService.getExchangeRate(currencyCode);
    }
}