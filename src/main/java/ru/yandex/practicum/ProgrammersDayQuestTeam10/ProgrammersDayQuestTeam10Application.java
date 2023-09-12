package ru.yandex.practicum.ProgrammersDayQuestTeam10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.client.Client;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.dto.AuthResponseDto;
import java.io.*;
import java.util.*;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ProgrammersDayQuestTeam10Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProgrammersDayQuestTeam10Application.class, args);
		String response = Client.sendPassword("1");

		while (!response.startsWith("200")) {

			String password = Client.generateRandomPassword(5);
			System.out.println(password);
			response = Client.sendPassword(password);
			System.out.println(response);
		}
		}
	}

