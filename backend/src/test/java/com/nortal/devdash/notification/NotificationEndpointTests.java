package com.nortal.devdash.notification;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nortal.devdash.notification.model.Notification;

@RunWith(SpringRunner.class)
@WebMvcTest(NotificationEndpoint.class)
public class NotificationEndpointTests {

    /*
     * Loading partial Spring context to test something, kind of bad
     * but it is a RestController we are testing so what else could we do?
     */

    @Autowired
    private MockMvc mvc;
    @MockBean
    private NotificationUseCase notificationUseCase;

    @Test
    public void returnsNotificationsWhenPresent() throws Exception {
        given(notificationUseCase.getNotifications())
                .willReturn(Arrays.asList(notification("Notification 1"),
                                          notification("Notification 2")));

        mvc.perform(get("/notification"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].text", is("Notification 1")))
                .andExpect(jsonPath("$[1].text", is("Notification 2")));

        verify(notificationUseCase).getNotifications();
    }

    private Notification notification(String text) {
        Notification notification = new Notification();
        notification.setText(text);
        return notification;
    }
}
