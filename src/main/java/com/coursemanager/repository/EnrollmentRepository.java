package com.coursemanager.repository;

import com.coursemanager.model.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Integer> {
}
