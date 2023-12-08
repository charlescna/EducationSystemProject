package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public @ResponseBody Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/view/{id}")
    public @ResponseBody Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/modify/{id}")
    public @ResponseBody Student modifyStudent(@PathVariable Integer id, @RequestBody Student modifiedStudent) {
        return modifiedStudent;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return "Student Deleted";
    }
}

