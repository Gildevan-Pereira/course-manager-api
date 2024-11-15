package com.coursemanager.controller;

import com.coursemanager.model.dto.request.EnrollmentRequestDto;
import com.coursemanager.model.dto.response.EnrollmentResponseDto;
import com.coursemanager.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> createEnrollment(@RequestBody EnrollmentRequestDto dto) {
        var course = enrollmentService.createEnrollment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<List<EnrollmentResponseDto>> findAllEnrollmentById(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        var course = enrollmentService.findAllEnrollmentsById(studentId, courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}