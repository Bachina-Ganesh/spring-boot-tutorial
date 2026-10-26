package org.example._6_aop_demo_2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GeneralAspect {

//    @Before(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))")
//    public void beforeCreateStudent(JoinPoint joinPoint) {
//        System.out.println("Method execution started");
//    }

//    @AfterReturning(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))",
//            returning = "result")
//    public void doAfterReturning(JoinPoint joinPoint, Object result) {
//        System.out.println("After General : "+result);
//    }

//    @AfterThrowing(value = "execution(* org.example._6_aop_demo_2.service.StudentService.createStudent(..))",
//            throwing = "exception")
//    public void afterThrowing(JoinPoint joinPoint, RuntimeException exception) {
//        System.out.println("After throwing General: "+exception.getClass().getName());
//        System.out.println("Exception message General: "+exception.getMessage());
//    }
}
