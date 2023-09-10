package ru.yandex.practicum.ProgrammersDayQuestTeam10.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.yandex.practicum.ProgrammersDayQuestTeam10.dto.RequestDto;

@Service
public class Client extends BaseClient{

    private static final String API_PREFIX = "/register";

    @Autowired
    public Client(@Value("${practicum-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public ResponseEntity<Object> authorization(Long answer, RequestDto requestDto1) {
        return post("", answer, requestDto1);
    }
}