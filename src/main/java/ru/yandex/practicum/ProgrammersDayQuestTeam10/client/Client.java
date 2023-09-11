package ru.yandex.practicum.ProgrammersDayQuestTeam10.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class Client{
    public static String authorize(String requestBodyString, String uri, String token) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
            //    .header("Authorization", "Bearer <" + token + ">")
                .header("MAIN_ANSWER", "error")
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
