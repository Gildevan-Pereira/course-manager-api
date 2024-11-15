package com.coursemanager.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {

    private Integer id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

}
