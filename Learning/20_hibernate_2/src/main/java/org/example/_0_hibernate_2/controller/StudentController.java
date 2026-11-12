package org.example._0_hibernate_2.controller;

import org.example._0_hibernate_2.models.Student;
import org.example._0_hibernate_2.services.StudentService;
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
    public ResponseEntity<?>createStudent(@RequestBody Student student) {
        String response = this.studentService.createStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        Student response1 = this.studentService.getStudent(id);
        Student response2 = this.studentService.getStudent(id);
        return new ResponseEntity<>(response1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        String response = this.studentService.deleteStudent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        String response = this.studentService.updateStudent(student, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
