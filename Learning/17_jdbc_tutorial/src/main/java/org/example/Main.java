package org.example;

import org.example.models.Student;
import org.example.repository.StudentRepository;

public class Main {
    static void main() {
        Student student = new Student();
        student.setName("Lakshmi");
        student.setEmail("lakshmi@gmail.com");
        student.setAge(24);

        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent(student);
//        studentRepository.getStudentById(2L);
//        studentRepository.updateStudent(new Student(1L, "kalil", "kalil@gmail.com", 19), 1L);
          studentRepository.deleteStudentById(10L);
    }
}
