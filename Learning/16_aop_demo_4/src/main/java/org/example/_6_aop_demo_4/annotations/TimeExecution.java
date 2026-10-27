package org.example._6_aop_demo_4.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeExecution {
    long warnTimeOut() default 2000;
    String operation() default "";
}
