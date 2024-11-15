package com.coursemanager.repository;

import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    @Query("SELECT s.courses FROM StudentEntity s WHERE s.id = :studentId")
    List<CourseEntity> findCoursesByStudentId(@Param("studentId") Integer studentId);
}
