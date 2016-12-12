package com.nortal.devdash.notification.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nortal.devdash.notification.dao.NotificationRepository;
import com.nortal.devdash.notification.model.Notification;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAll() {
        return StreamSupport.stream(notificationRepository.findAll().spliterator(), Boolean.FALSE)
                .collect(Collectors.toList());
    }
}
