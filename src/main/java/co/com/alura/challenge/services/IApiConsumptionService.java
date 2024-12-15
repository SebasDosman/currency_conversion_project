package co.com.alura.challenge.services;

import java.net.http.HttpResponse;


public interface IApiConsumptionService {
    HttpResponse<String> getApiData(String currency);
}
