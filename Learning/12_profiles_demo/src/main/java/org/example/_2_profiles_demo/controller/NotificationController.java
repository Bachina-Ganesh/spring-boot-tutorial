package org.example._2_profiles_demo.controller;

import org.example._2_profiles_demo.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<String> sendNotification() {
        String message = this.notificationService.sendNotification();
        return ResponseEntity.ok(message);
    }
}
