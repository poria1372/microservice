package org.example.service;

import org.example.notification.NotificationRequest;
import org.example.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    public void send(NotificationRequest notificationRequest) {
        new Notification("product", notificationRequest.getMessage(), LocalDateTime.now());
    }
}
