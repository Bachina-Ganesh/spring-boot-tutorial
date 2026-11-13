package org.example._1_hibernate_3.controller;

import org.example._1_hibernate_3.models.Student;
import org.example._1_hibernate_3.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId) {
        String response = this.studentService.createStudent(student, deptId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = this.studentService.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
