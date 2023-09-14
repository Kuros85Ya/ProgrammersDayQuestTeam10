package ru.yandex.practicum.ProgrammersDayQuestTeam10.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class Client{
    public static String authorize(String requestBodyString, String uri, String token) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("MAIN_ANSWER", "error")
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getCode() throws IOException, InterruptedException {
        String uri = "http://ya.praktikum.fvds.ru:8080/dev-day/task/4";

        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("AUTH_TOKEN", "fafdd883-3740-4314-978b-c5db4471a50e")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }



    public static String sendAnswer(String answer) throws IOException, InterruptedException {
        String uri = "http://ya.praktikum.fvds.ru:8080/dev-day/task/4";

        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("AUTH_TOKEN", "fafdd883-3740-4314-978b-c5db4471a50e")
                .POST(HttpRequest.BodyPublishers.ofString("{\"congratulation\": \"" + answer  + "\"}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String decode(String input) throws IOException {
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        for (Charset set : charsetMap.values()) {

            try {
                byte[] bytes = input.getBytes(set);
                String encodedString = new String(bytes, "Cp1251");
                if (encodedString.startsWith("Позд")) {
                    return encodedString;
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("Не могу");
            }
        }
        return "Не нашел";
    }

    public static String decodeTest() throws UnsupportedEncodingException {
        String cyrillic = "їЮЧФаРТЫпХЬ ЮвЫШзЭго ЪЮЬРЭФг б ґЭХЬ ЮЯлвЭЮУЮ їаЮУаРЬЬШбвР";
        String corrected8String = new String(cyrillic.getBytes("Cp1252"), "Cp1251");
        return corrected8String;
    }

    public static String decrypt(String s, int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t >= 'A' && t <= 'Z') {
                int t1 = t - 'A' - offset;
                if (t1 < 0) t1 = 26 + t1;
                sb.append((char) (t1 + 'A'));
            } else if (t >= 'a' && t <= 'z') {
                int t1 = t - 'a' - offset;
                if (t1 < 0) t1 = 26 + t1;
                sb.append((char) (t1 + 'a'));
            }
            else if (t == ' ') {
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
