package com.nortal.devdash.notification.service;

import java.util.List;

import com.nortal.devdash.notification.model.Notification;

public interface NotificationService {
    List<Notification> getAll();
}
