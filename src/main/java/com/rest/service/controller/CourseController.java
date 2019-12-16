package com.rest.service.controller;

import com.rest.service.entity.Course;
import com.rest.service.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CourseController {

    @Resource
    private CourseRepository courseRepository;


    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable Long courseId) {
        return ResponseEntity.of(courseRepository.findCourseById(courseId));
    }
}
