package com.coursemanager.service;

import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.CourseRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final EnrollmentPopulator enrollmentPopulator;
    private final CourseRepository courseRepository;

    public CourseResponseDto createCourse(CourseRequestDto requestDto) {
        CourseEntity courseEntity = enrollmentPopulator.courserEntityFromRequest(requestDto);

        var savedCourse = courseRepository.save(courseEntity);

        return enrollmentPopulator.courseResponseFromEntity(savedCourse);
    }

    public List<CourseResponseDto> findAllCoursesByStudentId(Integer id) throws Exception {
        var courses = courseRepository.findAllByStudentId(id);
        if (courses.isEmpty()) {
            throw new Exception();
//            throw new BusinessException(MessageEnum.ORDER_HISTORY_NOT_FOUND, id.toString(), HttpStatus.NOT_FOUND);
        }
        return courses.stream().map(enrollmentPopulator::courseResponseFromEntity).toList();
    }
}
