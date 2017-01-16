package com.nortal.devdash.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nortal.devdash.notification.model.Notification;
import com.nortal.devdash.rest.ResponseEvent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("notification")
@ApiModel(value = "Notifications")
public class NotificationEndpoint {
    @Autowired
    private NotificationUseCase notificationUseCase;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(
            value = "Returns notification list",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = Notification.class)
    public ResponseEntity<List<Notification>> getNotifications() {
        return ResponseEvent.of(notificationUseCase.getNotifications()).requiredResponse();
    }
}
