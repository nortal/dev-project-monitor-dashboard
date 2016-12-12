package com.nortal.devdash.notification.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Notification type enum")
public enum NotificationType {
    INFO,
    WARNING,
    ERROR,
    MESSAGE;

    public String getCode() {
        return this.name();
    }

}
