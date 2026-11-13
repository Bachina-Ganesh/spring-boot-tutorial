package org.example._1_hibernate_3.service;

import org.example._1_hibernate_3.models.Department;
import org.example._1_hibernate_3.models.Student;
import org.example._1_hibernate_3.repository.DepartmentRepository;
import org.example._1_hibernate_3.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public String createDepartment(Department department) {
        departmentRepository.saveDepartment(department);
        return "Department Created Successfully";
    }

    @Transactional
    public Department getDepartment(Long id) {
        return departmentRepository.getDepartment(id);
    }

    @Transactional
    public String createDepartmentWithStudents(Department department) {
        departmentRepository.saveDepartment(department);
        List<Student> students = department.getStudents();
        Student student = students.get(0);
        student.setDepartment(department);
        studentRepository.createStudent(student);
        return "Department Created Successfully";
    }
}
