package com.rest.service.controller;

import com.rest.service.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    private static List<Course> courses =
            Arrays.asList(new Course(1L, "Web Services"), new Course(2L, "REST"), new Course(3L, "SOAP"),
                    new Course(4L, "Java EE"));

    @GetMapping("/courses")
    public Course getCourse(@RequestParam Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
