package com.nortal.devdash.ping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nortal.devdash.ping.model.PingInfo;

@Component
class PingInfoUseCase {
    @Autowired
    private PingInfoService pingInfoService;

    public List<PingInfo> getPingResult() {
        return pingInfoService.getAll();
    }
}
