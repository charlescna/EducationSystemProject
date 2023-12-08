package com.example.educationsystemproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    @PostMapping("/add")
    public @ResponseBody Enrollment addEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @GetMapping("/list/course/{courseId}")
    public @ResponseBody Iterable<Enrollment> getEnrollmentsByCourse(@PathVariable Integer courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @GetMapping("/list/student/{studentId}")
    public @ResponseBody Iterable<Enrollment> getEnrollmentsByStudent(@PathVariable Integer studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @PutMapping("/modify/{id}")
    public @ResponseBody Enrollment modifyEnrollment(@PathVariable Integer id, @RequestBody Enrollment modifiedEnrollment) {
        return modifiedEnrollment;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable Integer id) {
        return "Enrollment Deleted";
    }
}
