package com.nortal.devdash.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nortal.devdash.notification.model.Notification;

/*
 * Using UseCase abstraction is more clear than Interactor in object-oriented world.
 */

@Component
class NotificationUseCase {
    @Autowired
    private NotificationService notificationService;

    public List<Notification> getNotifications() {
        return notificationService.getAll();
    }

}
