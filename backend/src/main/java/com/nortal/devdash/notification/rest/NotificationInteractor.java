package com.nortal.devdash.notification.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nortal.devdash.notification.model.Notification;
import com.nortal.devdash.notification.service.NotificationService;

@Component
public class NotificationInteractor {
    @Autowired
    private NotificationService notificationService;

    public List<Notification> getNotifications() {
        return notificationService.getAll();
    }

}
