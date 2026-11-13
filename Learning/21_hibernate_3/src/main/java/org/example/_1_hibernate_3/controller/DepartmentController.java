package org.example._1_hibernate_3.controller;

import org.example._1_hibernate_3.models.Department;
import org.example._1_hibernate_3.models.Student;
import org.example._1_hibernate_3.repository.DepartmentRepository;
import org.example._1_hibernate_3.repository.StudentRepository;
import org.example._1_hibernate_3.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        String result = departmentService.createDepartment(department);
        return new  ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Department department = this.departmentService.getDepartment(id);
        return ResponseEntity.ok(department);
    }

    @PostMapping("/withstudent")
    public ResponseEntity<String> createDepartmentWithStudent(@RequestBody Department department) {
        String response = departmentService.createDepartmentWithStudents(department);
        return ResponseEntity.ok(response);
    }
}
