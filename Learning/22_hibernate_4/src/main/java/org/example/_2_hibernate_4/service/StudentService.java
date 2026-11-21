package org.example._2_hibernate_4.service;

import org.example._2_hibernate_4.model.Department;
import org.example._2_hibernate_4.model.Profile;
import org.example._2_hibernate_4.model.Student;
import org.example._2_hibernate_4.repository.DepartmentRepository;
import org.example._2_hibernate_4.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        System.out.println("Fetching student");
        Student student = this.studentRepository.findById(id);
        System.out.println("Fetching department");
        Department department = student.getDepartment();
        System.out.println("Fetching profile");
        Profile profile = student.getProfile();
        return student;
    }

    @Transactional
    public String deleteStudent(Long id) {
        Student student = this.studentRepository.findById(id);
        this.studentRepository.remove(student);
        return "Student deleted successfully";
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }
}
