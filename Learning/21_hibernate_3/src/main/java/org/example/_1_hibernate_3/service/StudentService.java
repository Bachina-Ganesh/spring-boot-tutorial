package org.example._1_hibernate_3.service;

import org.example._1_hibernate_3.models.Department;
import org.example._1_hibernate_3.models.Student;
import org.example._1_hibernate_3.repository.DepartmentRepository;
import org.example._1_hibernate_3.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;


    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String createStudent(Student student, Long deptId) {
        Department department = departmentRepository.getDepartment(deptId);
        student.setDepartment(department);
        studentRepository.createStudent(student);
        return "Student created successfully";
    }

    @Transactional
    public Student getStudent(Long id) {
        return studentRepository.getStudent(id);
    }
}
