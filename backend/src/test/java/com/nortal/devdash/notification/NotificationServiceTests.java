package com.nortal.devdash.notification;

import static com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder.builder;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nortal.devdash.notification.model.Notification;
import com.nortal.devdash.notification.model.NotificationType;

public class NotificationServiceTests {

    /*
     * Not using Spring context at all, the best scenario possible.
     * Using open-source Spring JPA Data mock framework to partially mock our repository,
     * which is actually allowing us to test even more than we need.
     * As we aren't writing any implementation code to queries, we don't need to test persistence layer.
     * That is already tested by Spring source base.
     */

    private NotificationService notificationService;
    private NotificationRepository notificationRepository;

    @Before
    public void setUp() throws Exception {
        notificationRepository = builder().mock(NotificationRepository.class);
        notificationService = new NotificationServiceImpl(notificationRepository);
    }

    @Test
    public void willReturnNotificationsIfPresent() {
        notificationRepository.save(notification("Notification", NotificationType.MESSAGE));
        List<Notification> notifications = notificationService.getAll();
        assertThat(notifications).isNotEmpty();

        Notification notification = notifications.get(0);
        assertThat(notification.getId()).isNotNull();
        assertThat(notification.getText()).isEqualTo("Notification");
        assertThat(notification.getType()).isEqualTo(NotificationType.MESSAGE);
    }

    private Notification notification(String text, NotificationType type) {
        Notification notification = new Notification();
        notification.setText(text);
        notification.setType(type);
        return notification;
    }
}
