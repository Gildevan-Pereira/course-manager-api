package com.coursemanager.controller;

import com.coursemanager.model.dto.request.StudentRequestDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto dto) {
        var course = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StudentResponseDto>> findStudentById(@PathVariable Integer id) {
        var course = studentService.findAllStudentByCourseId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}