package com.coursemanager.model.dto;

import com.coursemanager.model.dto.request.EnrollmentRequestDto;
import com.coursemanager.model.dto.request.StudentRequestDto;
import com.coursemanager.model.dto.response.EnrollmentResponseDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.model.entity.CourseEntity;
import com.coursemanager.model.dto.request.CourseRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
import com.coursemanager.model.entity.EnrollmentEntity;
import com.coursemanager.model.entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentPopulator {

    @Autowired
    private ModelMapper modelMapper;

    public CourseResponseDto courseResponseFromEntity(CourseEntity courseEntity) {
        return modelMapper.map(courseEntity, CourseResponseDto.class);
    }

    public CourseEntity courserEntityFromRequest(CourseRequestDto courseRequestDto) {
        return modelMapper.map(courseRequestDto, CourseEntity.class);
    }

    public StudentResponseDto studentResponseFromEntity(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentResponseDto.class);
    }

    public StudentEntity studentEntityFromRequest(StudentRequestDto studentRequestDto) {
        return modelMapper.map(studentRequestDto, StudentEntity.class);
    }

    public EnrollmentResponseDto enrollmentResponseFromEntity(EnrollmentEntity enrollmentEntity) {
        return modelMapper.map(enrollmentEntity, EnrollmentResponseDto.class);
    }

    public EnrollmentEntity enrollmentEntityFromRequest(EnrollmentRequestDto enrollmentRequestDto) {
        return modelMapper.map(enrollmentRequestDto, EnrollmentEntity.class);
    }
}
