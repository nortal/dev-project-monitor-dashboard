package com.nortal.devdash.notification;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortal.devdash.notification.model.Notification;

@Service
class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}
