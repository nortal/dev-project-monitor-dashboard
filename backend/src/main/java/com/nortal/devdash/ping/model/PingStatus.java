package com.nortal.devdash.ping.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Ping status enum")
public enum PingStatus {
    OK,
    ERROR,
    TIMEOUT;

    public String getCode() {
        return this.name();
    }
}
