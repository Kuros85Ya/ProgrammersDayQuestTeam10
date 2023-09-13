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

import static ru.yandex.practicum.ProgrammersDayQuestTeam10.client.Client.differentFlagPermutations;

@SpringBootApplication
public class ProgrammersDayQuestTeam10Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProgrammersDayQuestTeam10Application.class, args);
		String response = Client.sendPassword("word>");
		String[] arr = {"a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		// Given X
		int X = 4;
		String[] mutations = differentFlagPermutations(X, arr);
		int size = mutations.length;

		int i = 0;
		System.out.println(size);
		while (!response.startsWith("200") && i < size) {
			System.out.println(size - i);
			String password = mutations[i];
			System.out.println(password);
			response = Client.sendPassword(password);
			System.out.println(response);
			i++;
		}
	}
}

