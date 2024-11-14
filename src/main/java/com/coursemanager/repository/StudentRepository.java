package com.coursemanager.repository;

import com.coursemanager.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    List<StudentEntity> findAllByCourseId(Integer id);
}
