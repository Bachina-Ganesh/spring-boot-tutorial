package org.example._3_filters_demo1.repository;

import org.example._3_filters_demo1.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    private final Map<Long, Student> students = new HashMap<>();

    public String createStudent(Student student) {
        students.put(student.getId(), student);
        return "Student " + student.getId() + " has been created";
    }

    public Student getStudentById(Long id) {
        return students.get(id);
    }
}
