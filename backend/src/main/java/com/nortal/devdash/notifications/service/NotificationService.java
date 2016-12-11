package com.nortal.devdash.notifications.service;

import java.util.List;

import com.nortal.devdash.notifications.model.Notification;

public interface NotificationService {
    List<Notification> getAll();
}
