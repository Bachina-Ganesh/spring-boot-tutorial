package org.example._6_aop_demo_2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example._6_aop_demo_2.model.Student;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class LoggingAspect {
//
//    @Before(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))")
//    public void beforeCreateStudent(JoinPoint joinPoint) {
//        System.out.println("Before createStudent");
//    }

//    @AfterReturning(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))",
//    returning = "result")
//    public void doAfterReturning(JoinPoint joinPoint, Object result) {
//        System.out.println("After returning : "+result);
//    }

//    @AfterThrowing(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))",
//    throwing = "exception")
//    public void afterThrowing(JoinPoint joinPoint, RuntimeException exception) {
//        System.out.println("After throwing : "+exception.getClass().getName());
//        System.out.println("Exception message: "+exception.getMessage());
//    }
//
//    @After(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("After : "+joinPoint.getSignature().getName());
//    }

    @Around(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Student student = (Student) joinPoint.getArgs()[0];
        student.setId(2);
        System.out.println("Before Method Execution: " + joinPoint.getSignature().getName());
        Object result = null;

        try {
            result = joinPoint.proceed(new Object[]{student});
            System.out.println("After Returning: After Method Execution: " + joinPoint.getSignature().getName());
        }
        catch (Throwable throwable) {
            System.out.println("After Throwing: After Throwing Method Execution: " + joinPoint.getSignature().getName());
        }
        finally {
            System.out.println("Finally: After Method Execution: " + joinPoint.getSignature().getName());
        }
        return result;
    }
}
