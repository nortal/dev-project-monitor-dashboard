package com.nortal.devdash.notifications.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nortal.devdash.common.rest.ResponseEvent;
import com.nortal.devdash.notifications.model.Notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/notification")
@ApiModel(value = "Notifications")
public class NotificationController {

    @Autowired
    private NotificationInteractor notificationInteractor;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(
            value = "Returns notification list",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = Notification.class)
    public ResponseEntity<List<Notification>> getNotifications() {
        return ResponseEvent.create(notificationInteractor.getNotifications()).requiredResponse();
    }
}
