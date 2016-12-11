package com.nortal.devdash.notifications.dao;

import org.springframework.data.repository.CrudRepository;

import com.nortal.devdash.notifications.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
