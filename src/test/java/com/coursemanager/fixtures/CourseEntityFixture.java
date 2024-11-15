package com.coursemanager.fixtures;

import com.coursemanager.model.entity.CourseEntity;

import java.time.LocalDateTime;

public class CourseEntityFixture {

    public static CourseEntity buildDefault() {
        return CourseEntity.builder()
                .id(1)
                .name("Java")
                .description("Curso de Programação")
                .creationDate(LocalDateTime.parse("2024-11-14T14:15:41"))
                .students(null)
                .build();
    }
}
