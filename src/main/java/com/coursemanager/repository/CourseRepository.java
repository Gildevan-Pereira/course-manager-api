package com.coursemanager.repository;

import com.coursemanager.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    @Query("SELECT c FROM CourseEntity c JOIN c.students s WHERE s.id = :id")
    List<CourseEntity> findAllByStudentId(Integer id);
}
