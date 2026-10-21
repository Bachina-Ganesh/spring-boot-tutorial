package org.example._3_filters_demo1.services;

import org.example._3_filters_demo1.model.Student;
import org.example._3_filters_demo1.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String createStudent(Student student) {
        return this.studentRepository.createStudent(student);
    }

    public Student getStudentById(Long id) {
        Student student = this.studentRepository.getStudentById(id);
        if(student == null) {
            throw new RuntimeException("Student with id " + id + " not found");
        }
        return student;
    }
}
