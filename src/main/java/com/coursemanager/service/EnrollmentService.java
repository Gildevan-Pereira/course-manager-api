package com.coursemanager.service;

import com.coursemanager.exception.BusinessException;
import com.coursemanager.messages.MessageEnum;
import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.EnrollmentRequestDto;
import com.coursemanager.model.dto.response.EnrollmentResponseDto;
import com.coursemanager.model.entity.EnrollmentEntity;
import com.coursemanager.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EnrollmentResponseDto> findAllEnrollmentsById(Integer studentId, Integer courseId) {
        var student = enrollmentRepository.findAllByIdStudentIdAndIdCourseId(studentId, courseId);

        if (student.isEmpty()) {
            throw new BusinessException(MessageEnum.COURSES_NOT_FOUND, studentId.toString() + courseId.toString(), HttpStatus.NOT_FOUND);
        }
        return student.stream().map(enrollmentPopulator::enrollmentResponseFromEntity).toList();
    }
}
