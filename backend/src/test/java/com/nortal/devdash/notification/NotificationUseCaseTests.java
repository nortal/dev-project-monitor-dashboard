package com.nortal.devdash.notification;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nortal.devdash.notification.model.Notification;
import com.nortal.devdash.notification.model.NotificationType;

@RunWith(MockitoJUnitRunner.class)
public class NotificationUseCaseTests {

    /*
     * Letting Mockito perform injection, better than loading Spring context.
     */

    @InjectMocks
    private NotificationUseCase notificationUseCase;
    @Mock
    private NotificationService notificationService;

    @Test
    public void returnsNotificationsIfPresent() {
        Notification existing = notification(Long.valueOf(1L), "Notification", NotificationType.WARNING);
        given(notificationService.getAll())
                .willReturn(Arrays.asList(existing));

        List<Notification> notifications = notificationUseCase.getNotifications();
        assertThat(notifications).isNotEmpty();

        Notification notification = notifications.get(0);
        assertThat(notification.getId()).isEqualTo(Long.valueOf(1L));
        assertThat(notification.getText()).isEqualTo("Notification");
        assertThat(notification.getType()).isEqualTo(NotificationType.WARNING);
        assertThat(existing.hashCode()).isEqualTo(notification.hashCode());
        assertThat(existing.equals(notification)).isTrue();

        verify(notificationService).getAll();
    }

    private Notification notification(Long id, String text, NotificationType type) {
        Notification notification = new Notification();
        notification.setId(id);
        notification.setText(text);
        notification.setType(type);
        return notification;
    }
}
