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

		String[] sentences = Client.getCode().split("&quot;");
		String code = sentences[3];
		String offset =  sentences[7];
		String answer = Client.decrypt(code, Integer.parseInt(offset));
		System.out.println(answer);
		String response = Client.sendAnswer(answer);
		System.out.println(response);
		}
	}

