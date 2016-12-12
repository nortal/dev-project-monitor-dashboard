package com.nortal.devdash.notification.dao;

import org.springframework.data.repository.CrudRepository;

import com.nortal.devdash.notification.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
