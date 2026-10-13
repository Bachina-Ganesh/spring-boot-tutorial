package com.example._9_sms.controller;

import com.example._9_sms.models.Student;
import com.example._9_sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Controller Called");
        Student createdStudent = this.studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = this.studentService.getStudentById(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>>  getAllStudents() {
        List<Student> students = this.studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        boolean isDeleted = this.studentService.deleteStudentById(id);
        if(isDeleted) {
            return ResponseEntity.ok("Student deleted successfully");
        }
        return new ResponseEntity<>("Student not found with an id : "+ id +" to be deleted", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = this.studentService.updateStudentById(id, student);
        if(updatedStudent == null) {
            return new ResponseEntity<>("Student not found with an id : "+ id +" to be updated", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedStudent);
    }
}
