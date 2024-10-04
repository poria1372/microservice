package org.example.controller;

import org.example.notification.NotificationRequest;
import org.example.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
         notificationService.send(notificationRequest);
    }
}
