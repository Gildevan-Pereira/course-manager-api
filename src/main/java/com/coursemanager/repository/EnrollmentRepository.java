package com.coursemanager.repository;

import com.coursemanager.model.entity.CourseEnrollmentKey;
import com.coursemanager.model.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, CourseEnrollmentKey> {

    List<EnrollmentEntity> findAllByIdStudentIdAndIdCourseId(Integer studentId, Integer courseId);
}
