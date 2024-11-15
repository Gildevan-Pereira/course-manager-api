package com.coursemanager.fixtures;

import com.coursemanager.model.dto.response.StudentResponseDto;

import java.time.LocalDateTime;

public class StudentResponseDtoFixture {

    public static StudentResponseDto buildDefault() {
        return StudentResponseDto.builder()
                .id(1)
                .name("Java")
                .description("Curso de Programação")
                .creationDate(LocalDateTime.parse("2024-11-14T14:15:41"))
                .build();
    }
}
