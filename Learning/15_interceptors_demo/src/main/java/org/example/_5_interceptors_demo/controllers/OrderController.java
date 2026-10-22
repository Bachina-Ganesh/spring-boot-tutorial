package org.example._5_interceptors_demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<String> getOrders() {
        System.out.println("Getting orders");
        return ResponseEntity.ok("Orders");
    }
}
