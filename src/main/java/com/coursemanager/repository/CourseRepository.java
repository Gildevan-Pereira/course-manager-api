package com.coursemanager.repository;

import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    @Query("SELECT c.students FROM CourseEntity c WHERE c.id = :courseId")
    List<StudentEntity> findStudentsByCourseId(@Param("courseId") Integer courseId);

}
