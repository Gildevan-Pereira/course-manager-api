package com.coursemanager.model.dto.response;

import com.coursemanager.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {

    private Integer id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

    private List<StudentEntity> students;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime removedAt;

}
