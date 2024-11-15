package com.coursemanager.fixtures;

import com.coursemanager.model.dto.response.CourseResponseDto;

import java.time.LocalDateTime;

public class CourseResponseDtoFixture {

    public static CourseResponseDto buildDefault() {
        return CourseResponseDto.builder()
                .id(1)
                .name("Java")
                .description("Curso de Programação")
                .creationDate(LocalDateTime.parse("2024-11-14T14:15:41"))
                .build();
    }
}
