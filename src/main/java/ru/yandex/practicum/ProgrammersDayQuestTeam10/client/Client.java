package ru.yandex.practicum.ProgrammersDayQuestTeam10.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.*;

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
        String uri = "http://ya.praktikum.fvds.ru:8080/dev-day/task/2";

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
        String uri = "http://ya.praktikum.fvds.ru:8080/dev-day/task/2";

        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("AUTH_TOKEN", "fafdd883-3740-4314-978b-c5db4471a50e")
                .POST(HttpRequest.BodyPublishers.ofString("{\"decoded\": \"" + answer  + "\"}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String sendPassword(String answer) throws IOException, InterruptedException {
        String uri = "http://ya.praktikum.fvds.ru:8080/dev-day/task/3";

        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("AUTH_TOKEN", "fafdd883-3740-4314-978b-c5db4471a50e")
                .POST(HttpRequest.BodyPublishers.ofString("{\"password\": \"" + answer  + "\"}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() + response.body();
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

    public static String bruteForce(int size) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String[] differentFlagPermutations(int X,
                                                     String[] arr) {
        String[] ml = arr;

        for (int i = 0; i < ml.length; i++) {
            System.out.print(ml[i] + " ");
        }

        int count = ml.length;

        // Traverse all possible lengths
        for (int z = 0; z < X - 1; z++) {

            // Stores all combinations
            // of length z
            Vector<String> tmp = new Vector<String>();

            // Traverse the array
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < ml.length; k++) {
                    if (arr[i] != ml[k]) {

                        // Generate all
                        // combinations of length z
                        tmp.add(ml[k] + arr[i]);
                        count += 1;
                    }
                }
            }

            // Print all combinations of length z
            for (int i = 0; i < tmp.size(); i++) {
                System.out.print(tmp.get(i) + " ");
            }

            // Replace all combinations of length z - 1
            // with all combinations of length z
            ml = tmp.toArray(new String[tmp.size()]);
        }
        return ml;
    }

    public static Integer func() {
        int[] arr = {9, 4, 9, 6, 7, 4, 5};

        ArrayList<Integer> elements = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int j : arr) {
            elements.add(j);
            if (!counts.containsKey(j)) {
                counts.put(j, 1);
            } else {
                int currentCount = counts.get(j);
                counts.put(j, ++currentCount);
            }
        }

        for (Integer elem: elements) {
            if (counts.get(elem) == 1)
                return elem;
        }
        return null;
    }

    public static String generateRandomPassword(int len) {
// Диапазон ASCII – буквенно-цифровой (0-9, a-z, A-Z)
        final String chars = "0123456789ABCDEFabcdef";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

// каждая итерация цикла случайным образом выбирает символ из заданного
// диапазон ASCII и добавляет его к экземпляру `StringBuilder`

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
