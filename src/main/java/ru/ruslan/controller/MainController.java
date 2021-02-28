package ru.ruslan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ruslan.service.CurrencyService;

import java.math.BigDecimal;

/**
 * Главный контроллер
 */
@Slf4j
@RestController
@RequestMapping("/api/")
public class MainController {

    private final CurrencyService currencyService;

    public MainController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency/{currencyCode}")
    public void getCurrencyGif(@PathVariable String currencyCode) {
        log.info("currencyCode: {}", currencyCode);
        // Курс валюты по отношению к рублю
        BigDecimal rate = currencyService.getRate(currencyCode);

    }
}
