package com.coursemanager.controller;

import com.coursemanager.model.dto.request.CourseRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
import com.coursemanager.model.dto.response.StudentResponseDto;
import com.coursemanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto dto) {
        var course = courseService.createCourse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/{courseId}/students")
    public  ResponseEntity<List<StudentResponseDto>> getStudentsByCourseId(@PathVariable Integer courseId) {
        var students = courseService.findStudentsByCourseId(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
