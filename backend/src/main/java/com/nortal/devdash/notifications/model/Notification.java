package com.nortal.devdash.notifications.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Notification type")
    private NotificationType type;

}
