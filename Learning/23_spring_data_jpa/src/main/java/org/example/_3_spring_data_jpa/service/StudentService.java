package org.example._3_spring_data_jpa.service;

import org.example._3_spring_data_jpa.model.Student;
import org.example._3_spring_data_jpa.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findByIds(id).orElse(null);
    }

    public List<Student> getStudents(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "name").and(Sort.by(Sort.Direction.ASC, "id"));
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Student> studentPage = this.studentRepository.findAll(pageable);
        return studentPage.getContent();
    }


}
