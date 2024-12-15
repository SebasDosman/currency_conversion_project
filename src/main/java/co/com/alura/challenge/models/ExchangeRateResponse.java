package co.com.alura.challenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeRateResponse (
    @JsonAlias("base_code")
    String baseCode,

    @JsonAlias("conversion_rates")
    Map<String, Double> conversionRates
) {
    public double getRate(String currency) {
        return conversionRates.get(currency);
    }
}
