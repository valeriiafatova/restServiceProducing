package com.rest.service.repository;

import com.rest.service.entity.Course;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component(value = "courseRepository")
public class CourseRepository {
    private static List<Course> courses =
            Arrays.asList(new Course(1L, "Web Services"), new Course(2L, "REST"), new Course(3L, "SOAP"),
                    new Course(4L, "Java EE"));
    
    public Optional<Course> findCourseById(Long courseId){
        return courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst();
    }

    public List<Course> findAll(){
        return courses;
    }
}
