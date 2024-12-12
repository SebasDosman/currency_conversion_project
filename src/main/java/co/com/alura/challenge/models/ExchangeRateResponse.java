package co.com.alura.challenge.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;


@Data
public class ExchangeRateResponse {
    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public double getRate(String currency) {
        return conversionRates.get(currency);
    }
}
