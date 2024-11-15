package com.coursemanager.controller;

import com.coursemanager.model.dto.request.CourseRequestDto;
import com.coursemanager.model.dto.response.CourseResponseDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<List<CourseResponseDto>> findCourseById(@PathVariable Integer id) {
        var course = courseService.findAllCoursesByStudentId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}
