package com.nortal.devdash.notifications.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Repository;

import com.nortal.devdash.notifications.model.Notification;
import com.nortal.devdash.notifications.model.NotificationType;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    @Override
    public <S extends Notification> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Notification> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Notification findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Notification> findAll() {
        List<Notification> notifications = new ArrayList<>();
        for (NotificationType type : NotificationType.values()) {
            notifications.add(createTestNotification(type));
        }

        return notifications;
    }

    @Override
    public Iterable<Notification> findAll(Iterable<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Notification entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends Notification> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    /* PRIVATE */

    private Notification createTestNotification(NotificationType type) {
        Notification notification = new Notification();
        notification.setId(RandomUtils.nextLong());
        notification.setText(type.getCode());
        notification.setType(type);

        return notification;
    }

}
