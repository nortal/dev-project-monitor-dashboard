package com.nortal.devdash.ping.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nortal.devdash.ping.model.PingInfo;
import com.nortal.devdash.ping.service.PingInfoService;

@Component
public class PingInteractor {

    @Autowired
    private PingInfoService pingInfoService;

    public List<PingInfo> getPingResult() {
        return pingInfoService.getAll();
    }
}
