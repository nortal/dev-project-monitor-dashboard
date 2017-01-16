package com.nortal.devdash.ping.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@ApiModel(value = "Ping info model object")
public class PingInfo implements Comparable<PingInfo> {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "Ping info  identificator")
    private Long id;

    @ApiModelProperty(value = "Inspected module name")
    private String module;

    @ApiModelProperty(value = "Status")
    @Enumerated(EnumType.STRING)
    private PingStatus status;

    @ApiModelProperty(value = "Status detailed info")
    private String statusDetail;

    @ApiModelProperty(value = "Checked address")
    private String url;

    @ApiModelProperty(value = "Check time")
    private Date checked;

    @ApiModelProperty(value = "Last response time")
    private Date lastResponded;

    @Override
    public int compareTo(PingInfo o) {
        if (o == null || this.getModule() == null || o.getModule() == null) {
            return -1;
        }
        return this.getModule().compareTo(o.getModule());
    }
}
