package com.example.educationsystemproject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseScript implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProgramsRepository programsRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private GradesRepository gradesRepository;

    @Override
    public void run(String... args) throws Exception {


        Student student1 = new Student("Alex", "Frazer", "alexfrazer@gmail.com", "140 Prince Blvd", "Brantford", "N2P 2G5", "632-333-2222");
        Student student2 = new Student("Jenifer", "Park", "jpark@gmail.com", "12 Cornwall Ave", "Winnipeg", "R4L 23G", "431-204-4432");
        Student student3 = new Student("Sarah", "Lasi", "slasi@gmail.com", "12 Margret Street", "Kitchener", "N2E 2G5", "519-333-4444");
        Student student4 = new Student("David", "Blinken", "dblinken@yahoo.com", "215 Rotwell Road", "Hamilton", "L8S 3R6", "905-444-3333");
        Student student5 = new Student("Emily", "Raul", "emily.raul@hotmail.com", "16 Halifax Street", "Vancouver", "V4C3K9", "604-332-0012");


        studentRepository.saveAll(List.of(student1, student2, student3, student4, student5));

        Course course1 = new Course("AWS", "CP2030", 21, 2023, "Fall", 1);
        Course course2 = new Course("Applied ASD", "CP3540", 22, 2023, "Winter", 2);

        courseRepository.saveAll(List.of(course1, course2));

        Programs program1 = new Programs("Accelerated Software Development", "Prince Philip");
        Programs program2 = new Programs("Accounting", "St John's");

        programsRepository.saveAll(List.of(program1, program2));

        Enrollment enrollment1 = new Enrollment(1, 1);
        Enrollment enrollment2 = new Enrollment(2, 2);
        Enrollment enrollment3 = new Enrollment(1, 3);
        Enrollment enrollment4 = new Enrollment(2, 4);
        Enrollment enrollment5 = new Enrollment(1, 5);

        enrollmentRepository.saveAll(List.of(enrollment1, enrollment2, enrollment3, enrollment4, enrollment5));
        Grades grade1 = new Grades();
        grade1.setStudentId(1);
        grade1.setCourseId(1);
        grade1.setGrade("A");

        Grades grade2 = new Grades();
        grade2.setStudentId(2);
        grade2.setCourseId(2);
        grade2.setGrade("B");

        Grades grade3 = new Grades();
        grade3.setStudentId(3);
        grade3.setCourseId(1);
        grade3.setGrade("C");

        Grades grade4 = new Grades();
        grade4.setStudentId(4);
        grade4.setCourseId(2);
        grade4.setGrade("D");

        Grades grade5 = new Grades();
        grade5.setStudentId(5);
        grade5.setCourseId(1);
        grade5.setGrade("E");

        gradesRepository.saveAll(List.of(grade1, grade2, grade3, grade4, grade5));
    }

}
