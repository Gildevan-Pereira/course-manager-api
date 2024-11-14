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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Integer courseId;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

}
