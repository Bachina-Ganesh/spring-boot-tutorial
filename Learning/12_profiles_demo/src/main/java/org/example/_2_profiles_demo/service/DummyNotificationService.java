package org.example._2_profiles_demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default"})
public class DummyNotificationService implements NotificationService {

    @Value("${application.main.message}")
    private String message;

    public DummyNotificationService() {
    }

    @Override
    public String sendNotification() {
        System.out.println(message);
        return "Sending Dummy Notifications";
    }
}
