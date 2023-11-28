package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse(
            @RequestParam String courseName,
            @RequestParam String courseNumber,
            @RequestParam int capacity
    ) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);

        courseRepository.save(course);
        return "Course Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/view/{id}")
    public @ResponseBody Course getCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
}


