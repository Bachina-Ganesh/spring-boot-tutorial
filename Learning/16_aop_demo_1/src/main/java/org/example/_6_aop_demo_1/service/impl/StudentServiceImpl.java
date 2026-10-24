package org.example._6_aop_demo_1.service.impl;

import org.example._6_aop_demo_1.entity.Student;
import org.example._6_aop_demo_1.repository.StudentRepository;
import org.example._6_aop_demo_1.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        Student createdStudent = this.studentRepository.save(student);
        return createdStudent;
    }
}
