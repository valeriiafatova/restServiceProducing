package com.rest.service.controller;

import com.rest.service.entity.Course;
import com.rest.service.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Resource
    private CourseRepository courseRepository;


    @GetMapping
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return ResponseEntity.of(courseRepository.findCourseById(id));
    }


}
