package com.coursemanager.repository;

import com.coursemanager.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    @Query("SELECT s FROM StudentEntity s JOIN s.courses c WHERE c.id = :id")
    List<StudentEntity> findAllByCourseId(Integer id);
}
