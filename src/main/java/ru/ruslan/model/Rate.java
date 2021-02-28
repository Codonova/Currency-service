package ru.ruslan.model;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Курс валют.
 */
public class Rate {
    private Integer                 timestamp;
    private String                  base;
    private Map<String, BigDecimal> rates;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
