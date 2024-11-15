package com.coursemanager.service;

import com.coursemanager.exception.BusinessException;
import com.coursemanager.messages.MessageEnum;
import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.StudentRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.model.entity.StudentEntity;
import com.coursemanager.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final EnrollmentPopulator enrollmentPopulator;
    private final StudentRepository studentRepository;

    public StudentResponseDto createStudent(StudentRequestDto requestDto) {
        StudentEntity studentEntity = enrollmentPopulator.studentEntityFromRequest(requestDto);

        var savedStudent = studentRepository.save(studentEntity);
        log.info("StudentService.createStudent: Student Saved Successful | studentId: {}", savedStudent.getId());

        return enrollmentPopulator.studentResponseFromEntity(savedStudent);
    }

    public List<CourseResponseDto> findCoursesByStudentId(Integer id) {
        var courses = studentRepository.findCoursesByStudentId(id);
        if (courses.isEmpty()) {
            throw new BusinessException(MessageEnum.COURSES_NOT_FOUND, id.toString(), HttpStatus.NOT_FOUND);
        }
        return courses.stream().map(enrollmentPopulator::courseResponseFromEntity).toList();
    }
}
