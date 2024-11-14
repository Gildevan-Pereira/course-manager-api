package com.coursemanager.service;

import com.coursemanager.model.dto.EnrollmentPopulator;
import com.coursemanager.model.dto.request.StudentRequestDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.model.entity.StudentEntity;
import com.coursemanager.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final EnrollmentPopulator enrollmentPopulator;
    private final StudentRepository studentRepository;

    public StudentResponseDto createStudent(StudentRequestDto requestDto) {
        StudentEntity studentEntity = enrollmentPopulator.studentEntityFromRequest(requestDto);

        var savedStudent = studentRepository.save(studentEntity);

        return enrollmentPopulator.studentResponseFromEntity(savedStudent);
    }

    public List<StudentResponseDto> findAllStudentByCourseId(Integer id) throws Exception {
        var student = studentRepository.findAllByCourseId(id);
        if (student.isEmpty()) {
            throw new Exception();
//            throw new BusinessException(MessageEnum.ORDER_HISTORY_NOT_FOUND, id.toString(), HttpStatus.NOT_FOUND);
        }
        return student.stream().map(enrollmentPopulator::studentResponseFromEntity).toList();
    }
}
