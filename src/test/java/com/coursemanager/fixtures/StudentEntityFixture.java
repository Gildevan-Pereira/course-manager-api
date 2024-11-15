package com.coursemanager.fixtures;

import com.coursemanager.model.entity.StudentEntity;

import java.time.LocalDateTime;

public class StudentEntityFixture {

    public static StudentEntity buildDefault() {
        return StudentEntity.builder()
                .id(1)
                .name("John Doe")
                .description("Aluno de Tecnologia")
                .creationDate(LocalDateTime.parse("2024-11-14T14:15:41"))
                .build();
    }
}
