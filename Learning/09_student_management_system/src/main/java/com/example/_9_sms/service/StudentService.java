package com.example._9_sms.service;

import com.example._9_sms.models.Student;
import com.example._9_sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setDeleted(false);
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = this.studentRepository.findByIdAndDeletedIsFalse(id);
        return student.orElse(null);
    }

    public List<Student> getAllStudents(){
        return this.studentRepository.findAllByDeletedIsFalse();
    }

    public boolean deleteStudentById(Long id) {
        Optional<Student> student = this.studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Student updateStudentById(Long id, Student student) {
        Optional<Student> studentOptional = this.studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentOptional.isPresent()) {
            Student updatedStudent = studentOptional.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setDeleted(false);
            updatedStudent.setId(id);
            updatedStudent.setAge(student.getAge());
            this.studentRepository.save(updatedStudent);
            return updatedStudent;
        }
        return null;
    }
}
