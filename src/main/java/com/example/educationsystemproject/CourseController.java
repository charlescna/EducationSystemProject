package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public @ResponseBody Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/view/{id}")
    public @ResponseBody Course getCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @PutMapping("/modify/{id}")
    public @ResponseBody Course modifyCourse(@PathVariable Integer id, @RequestBody Course modifiedCourse) {
        return modifiedCourse;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        return "Course Deleted";
    }
}



