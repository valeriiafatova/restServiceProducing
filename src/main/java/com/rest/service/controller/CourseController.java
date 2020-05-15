package com.rest.service.controller;

import com.rest.service.entity.Course;
import com.rest.service.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Resource
    private CourseRepository courseRepository;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return ResponseEntity.of(courseRepository.findCourseById(id));
    }


}
