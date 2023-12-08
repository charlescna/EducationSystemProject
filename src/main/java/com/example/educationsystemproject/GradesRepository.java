package com.example.educationsystemproject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradesRepository extends CrudRepository<Grades, Integer> {

    List<Grades> findByStudentId(Integer studentId);

    List<Grades> findByCourseId(Integer courseId);
}


