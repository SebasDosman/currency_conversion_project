package co.com.alura.challenge.services;

import co.com.alura.challenge.models.ExchangeValue;

import java.net.http.HttpResponse;


public interface IConverterService {
    ExchangeValue convertApiData(HttpResponse<String> response);
}
