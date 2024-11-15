package com.coursemanager.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDto {

    private Integer studentId;

    private Integer courseId;

    private LocalDateTime registrationDate;

}
