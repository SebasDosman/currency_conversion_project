package co.com.alura.challenge.services;

import java.io.IOException;
import java.net.http.HttpResponse;


public interface IApiConsumptionService {
    HttpResponse<String> getApiData(String currency) throws IOException, InterruptedException;
}
