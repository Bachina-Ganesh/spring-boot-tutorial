package org.example._4_filters_demo_2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<String> getOrders() {
        return ResponseEntity.ok().body("Retrived orders");
    }
}
