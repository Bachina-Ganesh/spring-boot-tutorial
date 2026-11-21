package org.example._2_hibernate_4.service;

import org.example._2_hibernate_4.model.Department;
import org.example._2_hibernate_4.model.Student;
import org.example._2_hibernate_4.repository.DepartmentRepository;
import org.example._2_hibernate_4.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String createStudent(Student student, Long id) {
        Department department = this.departmentRepository.findById(id);
        student.setDepartment(department);
        this.studentRepository.save(student);
        return "Student created successfully";
    }

    @Transactional
    public Student getStudent(Long id) {
        return this.studentRepository.findById(id);
    }

    @Transactional
    public String deleteStudent(Long id) {
        Student student = this.studentRepository.findById(id);
        this.studentRepository.remove(student);
        return "Student deleted successfully";
    }
}
