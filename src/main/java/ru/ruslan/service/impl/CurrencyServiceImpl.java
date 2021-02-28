package ru.ruslan.service.impl;

import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.ruslan.model.Rate;
import ru.ruslan.service.CurrencyService;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Реализация сервиса курса валют.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final Feign.Builder client;

    @Value("{app.urlCurrency}")
    private String urlCurrency;

    @Value("{app.baseCurrency}")
    private String baseCurrency;

    public CurrencyServiceImpl(Feign.Builder client) {
        this.client = client;
    }

    @Override
    public Map<String, String> getCurrencies() {
        //https://openexchangerates.org/api/currencies.json
        return client.target(Map.class, urlCurrency + "/currencies.json");
    }

    @Override
    public BigDecimal getRate(String currencyCode) {
        Rate rate = client.target(Rate.class, urlCurrency + "/latest.json?base=" + baseCurrency + "");
        Map<String, BigDecimal> rates = rate.getRates();
        return rates.getOrDefault(currencyCode, BigDecimal.valueOf(0));
    }

    @Override
    public BigDecimal getRateYesterday(String currencyCode) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Rate rate = client.target(Rate.class, urlCurrency + "/historical/" +
            yesterday.format(DateTimeFormatter.ISO_DATE) + ".json?base=" + baseCurrency);
        Map<String, BigDecimal> rates = rate.getRates();
        return rates.getOrDefault(currencyCode, BigDecimal.valueOf(0));
    }

    @Override
    public ByteBuffer getUpGif() {
        return null;
    }

    @Override
    public ByteBuffer getDownGif() {
        return null;
    }
}
