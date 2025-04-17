package br.com.alura.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
    private String apiBaseUrl = "https://v6.exchangerate-api.com/v6/892d14473662d9443e69895b/pair/";

    public ConverterResponse convertValue(String initialCurrency, String currencyToConvert, double value) {
        String apiUrl = this.apiBaseUrl + initialCurrency + "/" + currencyToConvert + "/" + value;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ConverterResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
