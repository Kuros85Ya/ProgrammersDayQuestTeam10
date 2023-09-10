package ru.yandex.practicum.ProgrammersDayQuestTeam10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.client.Client;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.dto.RequestDto;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Client client;

    @PostMapping
    public ResponseEntity<Object> authorization(@Value("${practicum-server.url}") String serverUrl,
                                                @RequestHeader("MAIN_ANSWER") Long answer,
                                                @RequestBody RequestDto requestDto) {
        ResponseEntity<Object> response = client.authorization(answer, requestDto);
        return response;
    }
}
