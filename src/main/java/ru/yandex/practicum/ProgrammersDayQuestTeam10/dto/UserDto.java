package ru.yandex.practicum.ProgrammersDayQuestTeam10.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDto {

    private String email;
    @EqualsAndHashCode.Exclude
    private String cohort;
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String lastName;
}
