package com.nortal.devdash.notification;

import org.springframework.data.repository.CrudRepository;

import com.nortal.devdash.notifications.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
