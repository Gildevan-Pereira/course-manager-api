package com.coursemanager.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private Integer id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

}
