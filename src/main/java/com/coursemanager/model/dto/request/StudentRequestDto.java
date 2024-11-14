package com.coursemanager.model.dto.request;


import com.coursemanager.model.entity.CourseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private String name;

    private String description;

    private LocalDateTime creationDate;

    private List<CourseEntity> courses;

}
