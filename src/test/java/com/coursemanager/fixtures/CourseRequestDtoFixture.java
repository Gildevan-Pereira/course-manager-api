package com.coursemanager.fixtures;

import com.coursemanager.model.dto.request.CourseRequestDto;

import java.time.LocalDateTime;

public class CourseRequestDtoFixture {

    public static CourseRequestDto buildDefault() {
        return CourseRequestDto.builder()
                .name("Java")
                .description("Curso de Programação")
                .creationDate(LocalDateTime.parse("2024-11-14T14:15:41"))
                .build();
    }
}
