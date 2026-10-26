package org.example._6_aop_demo_2.service;

import org.example._6_aop_demo_2.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student) {
        System.out.println("Student Created");
        if(student.getId() == 1) {
            throw new RuntimeException("Invalid Student Id");
        }
        return student;
    }
}
