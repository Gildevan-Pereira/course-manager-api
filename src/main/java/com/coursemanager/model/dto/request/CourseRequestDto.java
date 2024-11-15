package com.coursemanager.model.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {

    private String name;
    private String description;
    private LocalDateTime creationDate;
}
