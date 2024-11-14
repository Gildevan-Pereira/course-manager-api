package com.coursemanager.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDto {

    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private LocalDateTime registrationDate;

}
