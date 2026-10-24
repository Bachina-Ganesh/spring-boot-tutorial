package org.example._6_aop_demo_1.utility;

public class LoggingUtility {

    public static void startLog(String className, String methodName) {
        System.out.println("Execution started -> "+className + "." + methodName);
    }

    public static void endLog(String className, String methodName) {
        System.out.println("Execution ended -> "+className + "." + methodName);
    }
}
