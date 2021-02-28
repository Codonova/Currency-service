package ru.ruslan.service;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 *
 */
public interface CurrencyService {

    /**
     * Возвращает список валют
     */
    Map<String, String> getCurrencies();

    /**
     * Возвращает курс доллара
     *
     * @param currencyCode код валюты
     */
    BigDecimal getRate(String currencyCode);

    /**
     * Курс валюты за вчерашний день
     *
     * @param currencyCode код валюты
     * @return
     */
    BigDecimal getRateYesterday(String currencyCode);

    /**
     * Картинка для высокого курса.
     */
    ByteBuffer getUpGif();

    /**
     * Картинка для низкого курса.
     */
    ByteBuffer getDownGif();
}
