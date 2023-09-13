package ru.yandex.practicum.ProgrammersDayQuestTeam10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.client.Client;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.dto.AuthResponseDto;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

@SpringBootApplication
public class ProgrammersDayQuestTeam10Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProgrammersDayQuestTeam10Application.class, args);
		Map<String, Charset> charsetMap = Charset.availableCharsets();
		for (String s : charsetMap.keySet()) {
			System.out.println(s);
		}

		String cyrillic = "їЮЧФаРТЫпХЬ ЮвЫШзЭго ЪЮЬРЭФг б ґЭХЬ ЮЯлвЭЮУЮ їаЮУаРЬЬШбвР";
		Charset windows1252 = Charset.forName("windows-1251");

		byte[] bytes = cyrillic.getBytes(windows1252);
		String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

		System.out.println(utf8EncodedString);

//		String[] sentences = Client.getCode().split("<code id=\"congratulation\"><span>");
//
//		String[] code = sentences[1].split("</span>");
//		String exactCode = code[0];

//		String answer = Client.decode(cyrillic);
		Client.decode(cyrillic);
//		System.out.println(answer);
//		String response = Client.sendAnswer(answer);
//		System.out.println(response);
		}
	}

