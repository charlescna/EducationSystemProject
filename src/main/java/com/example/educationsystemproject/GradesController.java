package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping("/add")
    public @ResponseBody Grades addGrade(@RequestBody Grades grade) {
        return gradesRepository.save(grade);
    }

    @GetMapping("/list/student/{studentId}")
    public @ResponseBody Iterable<Grades> getGradesByStudent(@PathVariable Integer studentId) {
        return gradesRepository.findByStudentId(studentId);
    }

    @GetMapping("/list/course/{courseId}")
    public @ResponseBody Iterable<Grades> getGradesByCourse(@PathVariable Integer courseId) {
        return gradesRepository.findByCourseId(courseId);
    }

    @PutMapping("/modify/{id}")
    public @ResponseBody Grades modifyGrade(@PathVariable Integer id, @RequestBody Grades modifiedGrade) {
        return modifiedGrade;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGrade(@PathVariable Integer id) {
        return "Grade Deleted";
    }
}

