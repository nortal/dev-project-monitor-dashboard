package com.nortal.devdash.notifications.model;

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
