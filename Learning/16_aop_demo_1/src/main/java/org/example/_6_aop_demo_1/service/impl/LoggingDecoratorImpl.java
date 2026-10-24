package org.example._6_aop_demo_1.service.impl;

import org.example._6_aop_demo_1.entity.Student;
import org.example._6_aop_demo_1.service.StudentService;
import org.example._6_aop_demo_1.utility.LoggingUtility;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecoratorImpl implements StudentService {

    private final StudentServiceImpl studentService;
    public LoggingDecoratorImpl(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Override
    public Student createStudent(Student student) {
        LoggingUtility.startLog("StudentService", "createStudent");
        Student createdStudent = studentService.createStudent(student);
        LoggingUtility.endLog("StudentService", "createStudent");
        return createdStudent;
    }
}
