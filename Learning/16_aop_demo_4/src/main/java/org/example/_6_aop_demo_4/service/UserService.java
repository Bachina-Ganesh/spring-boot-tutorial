package org.example._6_aop_demo_4.service;

import org.example._6_aop_demo_4.annotations.TimeExecution;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @TimeExecution(operation = "Student Create")
    public String createUser() {
        return "User created";
    }

    @TimeExecution(operation = "Get User", warnTimeOut = 3000)
    public String getUser() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return "User Retrieved";
    }
}
