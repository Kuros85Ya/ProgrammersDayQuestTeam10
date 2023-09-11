package ru.yandex.practicum.ProgrammersDayQuestTeam10.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class AuthRequestDto {
    String name;
    String gitHubUrl;
    Set<UserDto> participants = new HashSet<>();
}
