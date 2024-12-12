package co.com.alura.challenge.services.implementations;

import co.com.alura.challenge.services.IApiConsumptionService;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiConsumptionService implements IApiConsumptionService {
    @Value("${application.api-key}")
    private String apiKey;

    @Override
    public HttpResponse<String> getApiData(String currency) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/".concat(apiKey).concat("/latest/").concat(currency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}