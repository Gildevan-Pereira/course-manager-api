package com.coursemanager.service;

import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.EnrollmentRequestDto;
import com.coursemanager.model.dto.response.EnrollmentResponseDto;
import com.coursemanager.model.entity.EnrollmentEntity;
import com.coursemanager.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentPopulator enrollmentPopulator;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentResponseDto createEnrollment(EnrollmentRequestDto requestDto) {
        EnrollmentEntity enrollmentEntity = enrollmentPopulator.enrollmentEntityFromRequest(requestDto);

        var savedEnrollment = enrollmentRepository.save(enrollmentEntity);

        return enrollmentPopulator.enrollmentResponseFromEntity(savedEnrollment);
    }
}
