package org.example._8_spring_jdbc_tut.controller;

import org.example._8_spring_jdbc_tut.models.Student;
import org.example._8_spring_jdbc_tut.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        String message = this.studentRepository.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = this.studentRepository.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = this.studentRepository.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
