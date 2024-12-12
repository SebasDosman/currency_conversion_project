package co.com.alura.challenge.services.implementations;

import co.com.alura.challenge.models.ExchangeRateResponse;
import co.com.alura.challenge.models.ExchangeValue;
import co.com.alura.challenge.services.IConverterService;
import com.google.gson.Gson;

import java.net.http.HttpResponse;


public class ConverterService implements IConverterService {
    @Override
    public ExchangeValue convertApiData(HttpResponse<String> response) {
        try {
            if (response == null || response.body() == null) throw new IllegalArgumentException("No data received from API");

            return ExchangeValue.fromApiResponse(new Gson().fromJson(response.body(), ExchangeRateResponse.class));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing API response: ".concat(e.getMessage()));
        }
    }
}
