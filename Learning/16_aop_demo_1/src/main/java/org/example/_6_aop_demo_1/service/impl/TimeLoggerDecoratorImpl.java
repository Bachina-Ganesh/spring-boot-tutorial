package org.example._6_aop_demo_1.service.impl;

import org.example._6_aop_demo_1.entity.Student;
import org.example._6_aop_demo_1.service.StudentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TimeLoggerDecoratorImpl implements StudentService {
    private final LoggingDecoratorImpl loggingDecorator;

    public TimeLoggerDecoratorImpl(LoggingDecoratorImpl loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public Student createStudent(Student student) {
        long startTime = System.currentTimeMillis();
        Student CreatedStudent = loggingDecorator.createStudent(student);
        long endTime = System.currentTimeMillis();
        System.out.println("TimeLoggerDecoratorImpl createStudent: " + (endTime - startTime));
        return CreatedStudent;
    }
}
