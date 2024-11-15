package com.coursemanager.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageEnum {

    GENERIC_ERROR("0001", "An error has occurred"),
    COURSES_NOT_FOUND("0100", "Courses not found for id: %s"),
    STUDENTS_NOT_FOUND("0101", "Student not found for id: %s");

    private final String code;
    private final String message;

}
