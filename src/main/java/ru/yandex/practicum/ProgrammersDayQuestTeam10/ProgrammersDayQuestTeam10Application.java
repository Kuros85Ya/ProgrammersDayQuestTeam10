package ru.yandex.practicum.ProgrammersDayQuestTeam10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.client.Client;

import java.io.IOException;

@SpringBootApplication
public class ProgrammersDayQuestTeam10Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProgrammersDayQuestTeam10Application.class, args);

		String url = "http://ya.praktikum.fvds.ru:8080/dev-day/register";
		String requestBody = "{\"name\": \"Триплет\", \"gitHubUrl\":\"https://github.com/Kuros85Ya/ProgrammersDayQuestTeam10\", \"participants\": [{\"email\": \"temporary-usr@yandex.ru\", \"cohort\": \"java_18\", \"firstName\": \"Alexey\", \"lastName\":\"Tumanov\"}, {\"email\": \"sobolevaalinaa@yandex.ru\", \"cohort\": \"java_21\", \"firstName\": \"Alina\", \"lastName\":\"Lyashenko\"}, {\"email\": \"daniil.vagin007@yandex.ru\", \"cohort\": \"java_33\", \"firstName\": \"Daniil\", \"lastName\":\"Vagin\"}]}";

		String response = Client.authorize(requestBody, url, "");
		System.out.println(response);
	}

}
