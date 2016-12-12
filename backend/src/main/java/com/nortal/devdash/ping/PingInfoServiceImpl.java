package com.nortal.devdash.ping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nortal.devdash.ping.model.PingInfo;

@Service
class PingInfoServiceImpl implements PingInfoService {
    @Autowired
    private PingInfoRepository pingInfoRepository;

    @Override
    public List<PingInfo> getAll() {
        return pingInfoRepository.findAll();
    }
}
