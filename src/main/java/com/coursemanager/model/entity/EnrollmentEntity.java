package com.coursemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollment")
public class EnrollmentEntity extends BaseEntity {

    @Column(name = "student_id")
    private Integer studentId;

    @ManyToMany()
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity studentEntity;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity courseEntity;
}
