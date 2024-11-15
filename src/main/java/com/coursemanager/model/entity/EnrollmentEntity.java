package com.coursemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollment")
public class EnrollmentEntity extends BaseEntity {

    @EmbeddedId
    private CourseEnrollmentKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity students;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private CourseEntity courses;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

}
