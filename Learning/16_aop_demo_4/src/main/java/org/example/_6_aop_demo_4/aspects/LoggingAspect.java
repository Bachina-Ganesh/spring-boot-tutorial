package org.example._6_aop_demo_4.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example._6_aop_demo_4.annotations.TimeExecution;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("@annotation(timeExecution)")
    public Object logTimeExecution(ProceedingJoinPoint joinPoint, TimeExecution timeExecution) throws Throwable {
        String signature = joinPoint.getSignature().toString();

        System.out.println("Method: " + signature+" is started for "+timeExecution.operation());

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long duration = end - start;
            String status = "Log";
            if(duration > timeExecution.warnTimeOut()){
                status = "Warning";
            }
            System.out.println(status+ ": Method: " + signature+" is finished in " + duration + " ms");
        }
    }
}
