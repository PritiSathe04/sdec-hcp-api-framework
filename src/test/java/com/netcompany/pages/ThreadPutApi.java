package com.netcompany.pages;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ThreadPutApi {
    public HttpResponse<String> putApiCallToThread(String url, String requestBody){
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("url: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            return response;

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("PUT request failed", e);
        }
    }
}
