package com.coursemanager.service;

import com.coursemanager.exception.BusinessException;
import com.coursemanager.messages.MessageEnum;
import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.CourseRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final EnrollmentPopulator enrollmentPopulator;
    private final CourseRepository courseRepository;

    public CourseResponseDto createCourse(CourseRequestDto requestDto) {
        CourseEntity courseEntity = enrollmentPopulator.courserEntityFromRequest(requestDto);

        var savedCourse = courseRepository.save(courseEntity);
        log.info("CourseService.createCourse: Course Saved Successful | courseId: {}", savedCourse.getId());

        return enrollmentPopulator.courseResponseFromEntity(savedCourse);
    }

    public List<StudentResponseDto> findStudentsByCourseId(Integer courseId) {
        var students = courseRepository.findStudentsByCourseId(courseId);
        if (students.isEmpty()) {
            throw new BusinessException(MessageEnum.STUDENTS_NOT_FOUND, courseId.toString(), HttpStatus.NOT_FOUND);
        }
        return students.stream().map(enrollmentPopulator::studentResponseFromEntity).toList();
    }


}
