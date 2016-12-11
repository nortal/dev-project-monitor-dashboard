package com.nortal.devdash.notifications.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nortal.devdash.notifications.model.Notification;
import com.nortal.devdash.notifications.service.NotificationService;

@Component
public class NotificationInteractor {

    @Autowired
    private NotificationService notificationService;

    public List<Notification> getNotifications() {
        return notificationService.getAll();
    }

}
