package org.example._6_aop_demo_4.controller;

import org.example._6_aop_demo_4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser() {
        return new ResponseEntity<>(userService.createUser(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
}
