package com.coursemanager.service;

import com.coursemanager.exception.BusinessException;
import com.coursemanager.fixtures.*;
import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    private CourseService courseService;

    @Mock
    private EnrollmentPopulator enrollmentPopulator;
    @Mock
    private CourseRepository courseRepository;

    @Captor
    private ArgumentCaptor<CourseEntity> courseEntityArgumentCaptor;

    @BeforeEach
    void setUp() {
        courseService = new CourseService(enrollmentPopulator, courseRepository);
    }

    @Test
    void shouldCreateCourseWithSuccessful() {
        var request = CourseRequestDtoFixture.buildDefault();
        var entity = CourseEntityFixture.buildDefault();
        var responseDto = CourseResponseDtoFixture.buildDefault();

        when(enrollmentPopulator.courserEntityFromRequest(request)).thenReturn(entity);
        when(courseRepository.save(courseEntityArgumentCaptor.capture())).thenReturn(entity);
        when(enrollmentPopulator.courseResponseFromEntity(entity)).thenReturn(responseDto);

        var response = courseService.createCourse(request);

        verify(courseRepository).save(courseEntityArgumentCaptor.capture());

        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getName()).isEqualTo(request.getName());
        assertThat(response.getDescription()).isEqualTo(request.getDescription());
        assertThat(response.getCreationDate()).isEqualTo(request.getCreationDate());

    }

    @Test
    void shouldFindStudentsByCourseIdWithSuccessful() {
        var courseId = 1;
        var entity = StudentEntityFixture.buildDefault();
        var responseDto = StudentResponseDtoFixture.buildDefault();

        when(courseRepository.findStudentsByCourseId(courseId)).thenReturn(List.of(entity));
        when(enrollmentPopulator.studentResponseFromEntity(entity)).thenReturn(responseDto);

        var response = courseService.findStudentsByCourseId(courseId);

        verify(courseRepository).findStudentsByCourseId(courseId);

        assertThat(response).isNotNull().isNotEmpty();
        assertThat(response.get(0).getId()).isEqualTo(courseId);
    }

    @Test
    void shouldBusinessExceptionWhenFindStudentsByCourseIdNotExists() {
        var courseId = 2;

        when(courseRepository.findStudentsByCourseId(anyInt())).thenReturn(Collections.emptyList());

        Executable executable = () -> courseService.findStudentsByCourseId(courseId);

        assertThrows(BusinessException.class, executable);
    }
}