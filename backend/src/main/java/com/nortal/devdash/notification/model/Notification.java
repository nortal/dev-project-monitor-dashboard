package com.nortal.devdash.notification.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@ApiModel(value = "Notification model object")
public class Notification {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "Notification identificator")
    private Long id;

    @ApiModelProperty(value = "Notification text")
    private String text;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Notification type")
    private NotificationType type;

}
