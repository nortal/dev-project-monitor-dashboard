package com.nortal.devdash.notifications.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
}
