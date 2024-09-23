package com.sio.javatd3sio2.tools;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestBuilder {
    //Creation du client HTTP
    private static HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> get(String url) throws URISyntaxException, IOException, InterruptedException {

        //Creation de la requete
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        // Envoi de la requete
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

//    public static String post(String url, String data) throws URISyntaxException, IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI(url))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString("{\"key\":\"value\"}"))
//                .build();
//
//        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
//    }
//
//    public static String put(String url, String data, String... token) throws URISyntaxException, IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI(url))
//                .header("Content-Type", "application/json")
//                .PUT(HttpRequest.BodyPublishers.ofString("{\"key\":\"value\"}"))
//                .build();
//
//        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
//    }
}

