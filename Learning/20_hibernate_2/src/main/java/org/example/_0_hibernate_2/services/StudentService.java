package org.example._0_hibernate_2.services;

import org.example._0_hibernate_2.models.Student;
import org.example._0_hibernate_2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public String createStudent(Student student) {
        String response = studentRepository.createStudent(student);
        System.out.println(response);
        return response;
    }

    @Transactional
    public Student getStudent(Long id) {
        Student student = studentRepository.getStudentById(id);
        System.out.println(student);
        return student;
    }

    @Transactional
    public String deleteStudent(Long id) {
        String response = studentRepository.deleteStudentById(id);
        System.out.println(response);
        return response;
    }

    @Transactional
    public String updateStudent(Student student, Long id) {
        Student student1 = studentRepository.getStudentById(id);
        student1.setName(student.getName());
        studentRepository.flush(student1);
        student1.setEmail(student.getEmail());
        studentRepository.detachStudent(student1);
        return "Student updated successfully";
    }

}
