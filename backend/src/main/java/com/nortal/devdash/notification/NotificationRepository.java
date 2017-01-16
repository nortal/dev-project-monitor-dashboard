package com.nortal.devdash.notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortal.devdash.notification.model.Notification;
import com.nortal.devdash.notification.model.NotificationType;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByText(String text);

    List<Notification> findByType(NotificationType type);

    // Perfect if we could skip creating a custom repository for this domain...
}
