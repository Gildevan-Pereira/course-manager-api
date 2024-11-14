package com.coursemanager.repository;

import com.coursemanager.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    List<CourseEntity> findAllByStudentId(Integer id);
}
