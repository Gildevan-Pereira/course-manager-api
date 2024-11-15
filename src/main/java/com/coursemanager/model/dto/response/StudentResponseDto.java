package com.coursemanager.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private Integer id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

}
