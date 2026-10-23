package org.example._5_interceptors_demo_1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<String> getOrders() {
        throw new RuntimeException("Invalid orders");
//        return new ResponseEntity<>("Orders found", HttpStatus.OK);
    }
}
